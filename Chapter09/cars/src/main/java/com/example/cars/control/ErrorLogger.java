package com.example.cars.control;

public class ErrorLogger {

    public void fatal(Throwable throwable) {
        throwable.printStackTrace();
    }

}
