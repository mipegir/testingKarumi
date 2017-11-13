package com.example.miguelangelperez.testkarumi;

import java.util.ArrayList;

/**
 * Created by miguelangel.perez on 13/11/2017.
 */

public class StringCalculator {
    public int sum(String input) throws Exception {

        String negativeResult = "";
        ArrayList<Integer> numbers = getNumbers(input);
        int total = 0;

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

    private ArrayList<Integer> getNumbers(String input) {
        if (input==null || input.isEmpty()) {
            return new ArrayList<Integer>() {};
        }

        String[] sNumbers = input.split("[,\\n]");
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
