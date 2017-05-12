package com.company;

import java.util.ArrayList;

public class CollectionForPriority {

    public  String result;

    public String PriorityCalc (String numbers){

        String [] a = numbers.split(" ");

        ArrayList <String> chars = new ArrayList<>();

        for (int i=0; i < a.length; i++){
            chars.add(a[i]);
        }

        int arraySize = chars.size();

        Arithmetic calculation = new Arithmetic();

        for (int j = 1; j < arraySize - 1; j++) {

            String charsPrev = chars.get(j-1);
            String charsNext = chars.get(j+1);

            if (chars.get(j).equals("*")) {
                    result = calculation.multiple(charsPrev, charsNext);
                    chars.set(j - 1, result);
                    chars.remove(j);
                    chars.remove(j);
                    arraySize = chars.size();
                    j--;
            } else {
                if (chars.get(j).equals("/")) {
                            result = calculation.divide(charsPrev, charsNext);
                            chars.set(j - 1, result);
                            chars.remove(j);
                            chars.remove(j);
                            arraySize = chars.size();
                            j--;
                            }
                }
            }
        for (int j = 1; j < arraySize - 1; j++) {

            String charsPrev = chars.get(j-1);
            String charsNext = chars.get(j+1);

            if (chars.get(j).equals("+")) {
                result = calculation.sum(charsPrev, charsNext);
                chars.set(j - 1, result);
                chars.remove(j);
                chars.remove(j);
                arraySize = chars.size();
                j--;
            } else {
                if (chars.get(j).equals("-")) {
                    result = calculation.difference(charsPrev, charsNext);
                    chars.set(j - 1, result);
                    chars.remove(j);
                    chars.remove(j);
                    arraySize = chars.size();
                    j--;
                }
            }
        }
        return result;
    }
}
