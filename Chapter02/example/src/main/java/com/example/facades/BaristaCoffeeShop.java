package com.example.facades;

public class BaristaCoffeeShop {

    private BeanStore beanStore;
    private Grinder grinder;
    private EspressoMachine espressoMachine;
    private Scale scale;
    private Thermometer thermometer;
    private Hygrometer hygrometer;

    GroundBeans grindBeans(Beans beans, double weight) {
        // ...
        return null;
    }

    Beans fetchBeans(BeanType type) {
        // ...
        return null;
    }

    double getTemperature() {
        // ...
        return 0.0;
    }

    double getHumidity() {
        // ...
        return 0.0;
    }

    Coffee makeEspresso(GroundBeans beans, Settings settings) {
        // ...
        return null;
    }

    // ...
    // required classes

    private class BeanStore {
    }

    private class Grinder {
    }

    private class EspressoMachine {
    }

    private class Scale {
    }

    private class Thermometer {
    }

    private class Hygrometer {
    }

    private class GroundBeans {
    }

    private class Beans {
    }

    private class BeanType {
    }

    private class Coffee {
    }

    private class Settings {
    }

}
