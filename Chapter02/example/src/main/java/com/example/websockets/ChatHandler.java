package com.example.websockets;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ChatHandler {

    public void initiateChat() {
        // ...
    }

    public void store(ChatMessage message) {
        System.out.println("message stored: " + message);
    }

    public void closeChat() {
        // ...
    }

}
