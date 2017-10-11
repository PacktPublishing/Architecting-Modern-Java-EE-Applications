package com.sebastian_daschner.coffee.shop;

public class BaristaCoffeeShop {

    private BeanStore beanStore;
    private Grinder grinder;
    private EspressoMachine espressoMachine;
    private Scale scale;
    private Thermometer thermometer;
    private Hygrometer hygrometer;

    GroundBeans grindBeans(Beans beans, double weight) { /**/ }

    Beans fetchBeans(BeanType type) { /**/ }

    double getTemperature() { /**/ }

    double getHumidity() { /**/ }

    Coffee makeEspresso(GroundBeans beans, Settings settings) { /**/ }

    //

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
