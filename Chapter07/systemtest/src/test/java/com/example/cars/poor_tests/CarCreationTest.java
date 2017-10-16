package com.example.cars.poor_tests;

import com.example.cars.Car;
import com.example.cars.Color;
import com.example.cars.EngineType;
import org.junit.Before;
import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

/**
 * An example for a poorly designed test scenario.
 * This class comprises too many concerns and abstractions layers.
 * And this example doesn't even cover the assembly line external system mock...
 */
public class CarCreationTest {

    private Client client;
    private WebTarget carsTarget;

    @Before
    public void setUp() {
        // ...
        client = ClientBuilder.newClient();
        carsTarget = client.target("http://test.car-manufacture.example.com/car-manufacture/resources/cars");
    }

    @Test
    public void testCarCreation() {
        String id = "X123A345";
        EngineType engine = EngineType.DIESEL;
        Color color = Color.RED;

        // verify car X123A345 not existent
        Response response = carsTarget.request().get();
        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.OK);

        List<Car> cars = response.readEntity(new GenericType<List<Car>>() {
        });
        if (cars.stream().anyMatch(c -> c.getId().equals(id)))
            fail("Car with id '" + id + "' existed before");

        // create car X123X345
        JsonObject json = Json.createObjectBuilder()
                .add("identifier", id)
                .add("engine-type", engine.name())
                .add("color", color.name())
                .build();

        response = carsTarget.request().post(Entity.json(json));
        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.CREATED);
        assertThat(response.getLocation().toString()).contains(id);

        // verify car X123A345
        response = carsTarget.path(id).request(APPLICATION_JSON_TYPE).get();
        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.OK);
        Car car = response.readEntity(Car.class);
        assertThat(car.getEngine()).isEqualTo(engine);
        assertThat(car.getColor()).isEqualTo(color);

        // verify car X123A345 existent in list
        response = carsTarget.request(APPLICATION_JSON_TYPE).get();
        assertThat(response.getStatusInfo()).isEqualTo(Response.Status.OK);
        cars = response.readEntity(new GenericType<List<Car>>() {
        });
        if (cars.stream().noneMatch(c -> c.getId().equals(id)))
            fail("Car with id '" + id + "' not existent");
    }

}
