package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cache {

    String trueNumber;

    private List<String> firstLevelCache = new LinkedList<>();

    private List<String> secondLevelCache = new ArrayList<>();


    public String getNumber(String x)
    {
        if (getNumberFromFirstLevel(x) != "")
        {
            trueNumber = getNumberFromFirstLevel(x);
            System.out.println(getNumberFromFirstLevel(x) + " got!");
        }
        else if (getNumberFromSecondLevel(x) != ""){

            trueNumber = getNumberFromSecondLevel(x);
            System.out.println(getNumberFromSecondLevel(x) + " got!");
        }
        return trueNumber;


    }


    public boolean checkNumber(String p){

        String number = p;

        for(int i = 0; i < firstLevelCache.size(); i++){

            String [] s = firstLevelCache.get(i).split(" = ");

            if(number.equals(s[0])){

                System.out.println("Check true");
                return true;

            }
        }
        for(int i = 0; i < secondLevelCache.size(); i++){

            String [] s = secondLevelCache.get(i).split(" = ");

            if(number.equals(s[0])){

                System.out.println("Check true");
                return true;

            }

        }
        return false;
    }


    public String getNumberFromFirstLevel(String x) {

        String number = x;
        String numberForReturn = "";

        for(int i = 0; i < firstLevelCache.size(); i++){

            String [] s = firstLevelCache.get(i).split(" = ");

            if(number.equals(s[0])){

                numberForReturn = s[1];

                String temp = firstLevelCache.get(i);
                firstLevelCache.set(i, firstLevelCache.get(0));
                firstLevelCache.set(0, temp);

            }
        }
        return numberForReturn;
    }


    private String getNumberFromSecondLevel(String x){

        String numberForReturn = "";

        String number = x;

        for(int i = 0; i < secondLevelCache.size(); i++){

            String [] s = secondLevelCache.get(i).split(" = ");

            if(number.equals(s[0])){

                numberForReturn = s[1];

            }
        }
        return numberForReturn;
    }

    public void addNumber(String s, String r){

        if(firstLevelCache.size() == 10) {

            for (int i=0; i <= firstLevelCache.size(); i++){

                if (i == 0) {

                    String temp = firstLevelCache.get(i);
                    secondLevelCache.add(temp);
                    firstLevelCache.remove(i);

                }
            }
        }
        firstLevelCache.add(s + " = " + r);

        System.out.println(firstLevelCache);
        System.out.println(secondLevelCache);

}
}
