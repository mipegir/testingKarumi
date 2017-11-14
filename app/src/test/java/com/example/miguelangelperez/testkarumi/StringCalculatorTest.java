package com.example.miguelangelperez.testkarumi;

import com.example.miguelangelperez.testkarumi.exceptions.InvalidSeparatorException;
import com.example.miguelangelperez.testkarumi.exceptions.NegativeException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

/**
 * Created by miguelangel.perez on 13/11/2017.
 */

public class StringCalculatorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    //Regla utilizada para indicar que una excepción no es un comportamiento válido a menos que lo indique en el test concreto.

    StringCalculator  calculator = new StringCalculator();

    @Test
    public void test_empty_string_return_0() throws Exception {

        int sum = calculator.sum("");

        assertEquals(0, sum);
    }

    @Test
    public void test_one_value_return_it () throws Exception {

        int sum = calculator.sum("1");

        assertEquals(1, sum);
    }

    @Test
    public void test_two_values_return_sum () throws Exception {

        int sum = calculator.sum("1,2");

        assertEquals(3, sum);
    }

    @Test
    public void test_six_numbers_return_sum () throws Exception {

        int sum = calculator.sum("1,2,3,4,5,6");

        assertEquals(21, sum);
    }

    @Test
    public void check_newline_numbers_return_sum () throws Exception {

        int sum = calculator.sum("1\n2,3,4,5\n6");

        assertEquals(21, sum);
    }

    @Test
    public void calc_negative_numbers_return_exception () throws Exception {

        String result = "";

        try {
            calculator.sum("1\n-2,3,4,-5\n6");
        }catch (Exception e){
            result= e.getMessage();
        }

        assertEquals("[-2,-5]", result);
    }

    @Test
    public void calc_negative_number_return_sum () throws Exception {

        String result = "";

        try {
            calculator.sum("1,3,4,-5,6");
        }catch (NegativeException e){
            result= e.getMessage();
        }

        assertEquals("[-5]", result);
    }

    @Test(expected = InvalidSeparatorException.class)
    public void get_exception_invalid_separator_sum () throws Exception {

        calculator.sum("1\n2|3,4,5\n6");

    }
}
