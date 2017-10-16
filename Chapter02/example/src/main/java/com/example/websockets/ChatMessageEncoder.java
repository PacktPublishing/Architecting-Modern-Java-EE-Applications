package com.example.websockets;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class ChatMessageEncoder implements Encoder.Text<ChatMessage> {

    @Override
    public String encode(ChatMessage object) throws EncodeException {
        return object.getContents();
    }

    @Override
    public void init(EndpointConfig config) {
        // nothing to do
    }

    @Override
    public void destroy() {
        // nothing to do
    }

}
