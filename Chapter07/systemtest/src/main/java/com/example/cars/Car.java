package com.example.cars;

import javax.json.bind.annotation.JsonbProperty;

public class Car {

    @JsonbProperty("identifier")
    private String id;
    @JsonbProperty("engine-type")
    private EngineType engine;
    private Color color;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
