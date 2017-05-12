package com.company;

import javax.swing.*;

public class Arithmetic {

    public String result;
    private double res, prev, next;

    public String multiple (String charsPrev, String charsNext){
        prev = Double.parseDouble(charsPrev);
        next = Double.parseDouble(charsNext);
        res = prev * next;
        result = Double.toString(res);
        return result;
    }
    public String divide (String charsPrev, String charsNext){
        prev = Double.parseDouble(charsPrev);
        next = Double.parseDouble(charsNext);
        if(next == 0)
        {
            result = "";
        } else {
            res = prev / next;
            result = Double.toString(res);
        }
        return result;
    }
    public String sum (String charsPrev, String charsNext){
        prev = Double.parseDouble(charsPrev);
        next = Double.parseDouble(charsNext);
        res = prev + next;
        result = Double.toString(res);
        return result;
    }
    public String difference (String charsPrev, String charsNext){
        prev = Double.parseDouble(charsPrev);
        next = Double.parseDouble(charsNext);
        res = prev - next;
        result = Double.toString(res);
        return result;
    }
}
