package com.example.async.cdi_events.control;

import com.example.async.cdi_events.entity.CarCreated;

import javax.enterprise.event.ObservesAsync;

public class CreatedCarListener {

    public void onCarCreated(@ObservesAsync CarCreated event) {
        // handle event asynchronously
    }

}
