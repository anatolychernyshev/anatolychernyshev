package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

    private String[] dataFromFile;

    public String[] read(){

        try (BufferedReader reader = new BufferedReader(new FileReader("Data.txt"))) {

            String s;

            while ((s = reader.readLine()) != null) {
                dataFromFile = s.split("#");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataFromFile;
    }
}
