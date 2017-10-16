package com.example.hypermedia_client;

import javax.json.JsonObject;
import java.net.URI;

public class Entity {

    private URI uri;
    private JsonObject properties;

    // actions, links, etc.

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    public JsonObject getProperties() {
        return properties;
    }

    public void setProperties(JsonObject properties) {
        this.properties = properties;
    }

}
