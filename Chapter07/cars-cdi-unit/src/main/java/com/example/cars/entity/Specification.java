package com.example.cars.entity;

public class Specification {

    private EngineType engine;
    private Color color;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specification that = (Specification) o;

        if (engine != that.engine) return false;
        return color == that.color;
    }

    @Override
    public int hashCode() {
        int result = engine != null ? engine.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }

}
