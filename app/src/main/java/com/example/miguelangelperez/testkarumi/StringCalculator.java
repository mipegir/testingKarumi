package com.example.miguelangelperez.testkarumi;

import com.example.miguelangelperez.testkarumi.exceptions.InvalidSeparatorException;
import com.example.miguelangelperez.testkarumi.exceptions.NegativeException;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by miguelangel.perez on 13/11/2017.
 */

public class StringCalculator {

    public static final String REGEX_VALID_CHARACTERS = "[\\-0-9,\\n]*";
    public static final String REGEX_EXPECTED_SEPARATOR = "[,\\n]";

    public int sum(String input) throws Exception {

        int total = 0;
        String negativeResult;
        ArrayList<Integer> numbers = getNumbers(input);

        //check input
        checkInvalidSeparator(input);

        //sum numbers
        for (int num : numbers) {
            total += num;
        }

        //check negatives
        negativeResult = getNegativeNumbers(numbers);
        if (!negativeResult.isEmpty()){
            throw new NegativeException(negativeResult);
        }
        return total;
    }

    private void checkInvalidSeparator(String input) throws InvalidSeparatorException {
        Pattern pattern = Pattern.compile(REGEX_VALID_CHARACTERS);
        if (!pattern.matcher(input).matches()){
            throw new InvalidSeparatorException();
        }
    }

    private ArrayList<Integer> getNumbers(String input) {
        if (input==null || input.isEmpty()) {
            return new ArrayList<Integer>() {};
        }

        String[] sNumbers = input.split(REGEX_EXPECTED_SEPARATOR);
        ArrayList<Integer> listNumbers = new ArrayList<>();
        for (String sNumber: sNumbers) {
            try {
                listNumbers.add(Integer.valueOf(sNumber));
            }catch (NumberFormatException Ignore){}
        }

        return listNumbers;

    }

    private String getNegativeNumbers(ArrayList<Integer> numbers) {

        String errorResult="";
        //sum numbers
        for (int nNumber: numbers) {
            if (nNumber<0){
                errorResult+=String.valueOf(nNumber) +",";
            }
        }
        if (!errorResult.isEmpty()) {
            errorResult = "[" + errorResult.substring(0, errorResult.length() - 1) + "]";
        }

        return errorResult;
    }

}
