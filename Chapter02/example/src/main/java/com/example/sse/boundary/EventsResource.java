package com.example.sse.boundary;

import com.example.sse.entity.DomainEvent;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;
import javax.ws.rs.sse.SseEventSink;
import java.util.ArrayList;
import java.util.List;

import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;

@Path("events-examples")
@Singleton
public class EventsResource {

    @Context
    Sse sse;

    private SseBroadcaster sseBroadcaster;
    private int lastEventId;
    private List<String> messages = new ArrayList<>();

    @PostConstruct
    public void initSse() {
        sseBroadcaster = sse.newBroadcaster();

        sseBroadcaster.onError((o, e) -> {
            // ...
        });
    }

    @GET
    @Lock(READ)
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public void itemEvents(@HeaderParam(HttpHeaders.LAST_EVENT_ID_HEADER)
                           @DefaultValue("-1") int lastEventId,
                           @Context SseEventSink eventSink) {

        if (lastEventId >= 0)
            replayLastMessages(lastEventId, eventSink);

        sseBroadcaster.register(eventSink);
    }

    private void replayLastMessages(int lastEventId, SseEventSink eventSink) {
        try {
            for (int i = lastEventId; i < messages.size(); i++) {
                eventSink.send(createEvent(messages.get(i), i + 1));
            }
        } catch (Exception e) {
            throw new InternalServerErrorException("Could not replay messages ", e);
        }
    }

    private OutboundSseEvent createEvent(String message, int id) {
        return sse.newEventBuilder().id(String.valueOf(id)).data(message).build();
    }

    @Lock(WRITE)
    public void onEvent(@Observes DomainEvent domainEvent) {
        String message = domainEvent.getContents();
        messages.add(message);

        OutboundSseEvent event = createEvent(message, ++lastEventId);

        sseBroadcaster.broadcast(event);
    }

}
