/* package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cache {

    String trueNumber;

    private List<Double> firstLevelCache = new LinkedList<>();

    private List<Double> secondLevelCache = new ArrayList<>();


    public String getNumber(String x)
    {
        if (getNumberFromFirstLevel(x) != 0)
        {
            trueNumber = String.valueOf(getNumberFromFirstLevel(x));
        }
        else if (getNumberFromSecondLevel(x) != 0){

            trueNumber = String.valueOf(getNumberFromSecondLevel(x));
        }
        return trueNumber;


    }

    public boolean checkNumber(String p){

        double number = Double.parseDouble(p);

        for(int i = 0; i < firstLevelCache.size(); i++){

            if(number == firstLevelCache.get(i)){

                return true;
            }
        }
        for(int i = 0; i < secondLevelCache.size(); i++){

            if(number == secondLevelCache.get(i)){

                return true;
            }

        }
        return false;
    }
    //getFirst getLast
    private double getNumberFromFirstLevel(String x) {

        double number = Double.parseDouble(x);
        double numberForReturn = 0;
        for(int i = 0; i < firstLevelCache.size(); i++){

            if(number == firstLevelCache.get(i)){

                numberForReturn = firstLevelCache.get(i);

                double temp = firstLevelCache.get(i);

                firstLevelCache.set(i, firstLevelCache.get(0));
                firstLevelCache.set(0, temp);
            }
        }
        return numberForReturn;
    }
    private double getNumberFromSecondLevel(String x){

        double numberForReturn = 0;

        double number = Double.parseDouble(x);

        for(int i = 0; i < secondLevelCache.size(); i++){

            if(number == secondLevelCache.get(i)){

                numberForReturn = secondLevelCache.get(i);
            }
        }
        return numberForReturn;
    }
    public void addNumber(String x){

        if(firstLevelCache.size() == 10) {

            double temp = firstLevelCache.get(9);

            secondLevelCache.add(temp);

            firstLevelCache.remove(9);
        }
        else {
            firstLevelCache.add(Double.parseDouble(x));
        }
    }
}
*/