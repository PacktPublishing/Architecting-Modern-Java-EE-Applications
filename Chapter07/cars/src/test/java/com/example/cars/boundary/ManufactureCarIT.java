package com.example.cars.boundary;

import com.example.cars.control.AssemblyLine;
import com.example.cars.control.Automation;
import com.example.cars.control.CarFactory;
import com.example.cars.entity.Car;
import com.example.cars.entity.Specification;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(Arquillian.class)
public class ManufactureCarIT {

    @Inject
    CarManufacturer carManufacturer;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(CarManufacturer.class)
                .addClasses(CarFactory.class, AssemblyLine.class, Automation.class)
                .addClasses(Car.class, Specification.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
                // required for this Arquillian example, since EntityManager is being used
                .addAsResource("META-INF/persistence.xml");
    }

    @Test
    public void test() {
        Specification spec = new Specification();
        Car expected = new Car(spec);
        assertThat(carManufacturer.manufactureCar(spec)).isEqualTo(expected);
    }

}
