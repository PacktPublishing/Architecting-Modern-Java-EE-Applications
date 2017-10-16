package com.example.cars.control;

import javax.enterprise.inject.Produces;
import java.util.function.Consumer;

public class LoggerExposer {

    @Produces
    public Consumer<Throwable> fatalErrorConsumer() {
        return Throwable::printStackTrace;
    }

}
