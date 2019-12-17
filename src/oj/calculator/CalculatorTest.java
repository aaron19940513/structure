package oj.calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {
    private static Calculator calculator = new Calculator();


    @Test
    public void testAdd() {
       // double result = calculator.calc("(6+4)*2/(1.1+2.9)");
        double result = calculator.calc("6+4*2");
        assertEquals(5, result);

    }
}
