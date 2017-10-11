package coffee;

import org.junit.Test;

public class CoffeeTest {

    @Test
    public void test() {
        Coffee coffee = new CreamCoffee(new SugarCoffee(new BlackCoffee()));
        double caffeine = coffee.getCaffeine(); // 100.0
        double calories = coffee.getCalories(); // 130.0

        System.out.println("caffeine = " + caffeine);
        System.out.println("calories = " + calories);
    }

}