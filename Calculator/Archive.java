/*  package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archive {
    public static void fullLog(String EXPATH, String PATH, String ZIPPATH) throws IOException {

        File f = null;
        File f1 = null;
        File f2 = null;

        f = new File(EXPATH);
        f2 = f;
        f1 = new File(PATH);

        f.renameTo(f1);
        f2.createNewFile();

        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(ZIPPATH));
        FileInputStream fileInputStream = new FileInputStream("ex-Math.txt");
        ZipEntry zipEntry = new ZipEntry(EXPATH);
        zipOutputStream.putNextEntry(zipEntry);
        byte [] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        zipOutputStream.write(buffer);
        zipOutputStream.closeEntry();
        zipOutputStream.close();



    }
}
    */