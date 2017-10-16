package com.example.websockets;

public class ChatMessage {

    private final String contents;

    public ChatMessage(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "contents='" + contents + '\'' +
                '}';
    }
}
