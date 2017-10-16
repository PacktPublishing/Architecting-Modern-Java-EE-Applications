package com.example.factories.entity;

public class Car {

    private String id;
    private EngineType engine;
    private Color color;

    public LogBook createDriverLog() {
        // create logbook statement

        // ...
        return new LogBook();
    }

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
