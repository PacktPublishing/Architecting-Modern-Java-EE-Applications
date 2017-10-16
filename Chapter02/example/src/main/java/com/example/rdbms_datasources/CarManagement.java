package com.example.rdbms_datasources;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class CarManagement {

    @Inject
    @VehicleDB
    EntityManager entityManager;

    // replaceEngine
    // ...

}
