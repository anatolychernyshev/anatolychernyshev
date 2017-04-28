package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archive {



    public static void fullLog(String EXPATH, String PATH, String ZIPPATH) throws IOException {

        File f = new File(PATH);
        File temp = f;
        File f1 = new File(EXPATH);

        FileReader fileReader = new FileReader(PATH);
        LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
        int i = 0;

        while (lineNumberReader.readLine() != null){
            i++;
            System.out.println("Line: " + i);
            if (i > 10) {

                f.renameTo(f1);
                temp.createNewFile();

                try(ZipOutputStream zOut = new ZipOutputStream(new FileOutputStream(ZIPPATH));
                    FileInputStream fileInputStream = new FileInputStream(EXPATH))
                {
                    ZipEntry zipEntry = new ZipEntry("ex-Math.txt");
                    zOut.putNextEntry(zipEntry);
                    byte[] buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                    zOut.write(buffer);
                    zOut.closeEntry();
                }
                catch(Exception ex){

                    System.out.println(ex.getMessage());
                }

                f1.delete();
                break;
            }
        }
    }
}