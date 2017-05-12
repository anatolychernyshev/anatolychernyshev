package com.company;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Archive {

    public static void fullLog(String EXPATH, String PATH, String ZIPPATH) throws IOException {

        FileReader fileReader = new FileReader("Math.txt");
        LineNumberReader lineNumberReader = new LineNumberReader(fileReader);

        int k = 0;

        while (lineNumberReader.readLine() != null) {

            k++;

            System.out.println(lineNumberReader.readLine() + "    #" + k);
            if (k > 10) {

                fileReader.close();

                File old = new File(PATH);
                File temp = old;
                File renamed = new File(EXPATH);
                if (old.renameTo(renamed)){
                    System.out.println("File renamed!");
                } else {
                    System.out.println("Can`t to rename the file!");
                }

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

                renamed.delete();

                break;
            }
        }
    }
}