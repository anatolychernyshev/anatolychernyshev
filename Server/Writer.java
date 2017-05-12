package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public static void write(String fileToData, String message) throws IOException {
        BufferedWriter wr = new BufferedWriter(new FileWriter(fileToData,true));
        wr.write("\r" + "\n" + message);
        wr.flush();
        wr.close();
    }
}
