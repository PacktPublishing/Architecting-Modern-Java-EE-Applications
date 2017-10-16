package com.example.cross_cutting.control;

public class ProcessTracker {

    public void track(Category category) {
        // ...
        System.out.println("tracking: " + category);
    }

    public enum Category {
        MANUFACTURER, UNUSED
    }

}
