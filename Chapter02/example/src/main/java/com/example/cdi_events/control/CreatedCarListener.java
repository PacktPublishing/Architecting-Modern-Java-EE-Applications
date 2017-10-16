package com.example.cdi_events.control;

import com.example.cdi_events.entity.CarCreated;
import com.example.cdi_events.entity.Specification;

import javax.enterprise.event.Observes;

public class CreatedCarListener {

    public void onCarCreated(@Observes CarCreated event) {
        Specification spec = event.getSpecification();
        // handle event
    }

}
