package com.example.miguelangelperez.testkarumi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by miguelangel.perez on 13/11/2017.
 */

public class StringCalculatorTest {

    @Test
    public void test_empty_string_return_0() throws Exception {
        StringCalculator  calculator = new StringCalculator();
        int sum = calculator.sum("");
        assertEquals(0, sum);
    }

    @Test
    public void test_one_value_return_it () throws Exception {
        StringCalculator  calculator = new StringCalculator();
        int sum = calculator.sum("1");
        assertEquals(1, sum);
    }

    @Test
    public void test_two_values_return_sum () throws Exception {
        StringCalculator  calculator = new StringCalculator();
        int sum = calculator.sum("1,2");
        assertEquals(3, sum);
    }

    @Test
    public void test_six_numbers_return_sum () throws Exception {
        StringCalculator  calculator = new StringCalculator();
        int sum = calculator.sum("1,2,3,4,5,6");
        assertEquals(21, sum);
    }

    @Test
    public void test_newline_numbers_return_sum () throws Exception {
        StringCalculator  calculator = new StringCalculator();
        int sum = calculator.sum("1\n2,3,4,5\n6");

        assertEquals(21, sum);
    }

    @Test
    public void calc_negative_numbers_return_sum () throws Exception {
        StringCalculator  calculator = new StringCalculator();
        String result = "";

        try {
            calculator.sum("1\n-2,3,4,-5\n6");
        }catch (Exception e){
            result= e.getMessage();
        }

        assertEquals("[-2,-5]", result);
    }

}
