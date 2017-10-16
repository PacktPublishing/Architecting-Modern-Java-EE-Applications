package com.example.websockets;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class ChatMessageDecoder implements Decoder.Text<ChatMessage> {

    @Override
    public ChatMessage decode(String string) throws DecodeException {
        return new ChatMessage(string);
    }

    @Override
    public boolean willDecode(String string) {
        return true;
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
