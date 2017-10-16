package com.example.hello_cloud.control;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.concurrent.TimeUnit;

@ApplicationScoped
public class HelloCloudProcessor {

    private Client client;
    private WebTarget target;

    @PostConstruct
    private void initClient() {
        client = ClientBuilder.newBuilder()
                .connectTimeout(100, TimeUnit.MILLISECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .build();
        target = client.target("http://cloud-processor:8080/processor/resources/hello");
    }

    public String processGreeting() {
        return target.request().get(String.class);
    }

    @PreDestroy
    public void closeClient() {
        client.close();
    }

}
