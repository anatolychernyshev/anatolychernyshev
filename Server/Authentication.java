package com.company;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.ECField;

public class Authentication {

    private String login;
    private String password;


    public Authentication(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /*
    Codes:
    -1 - failed Auth(wrong log or password);
    0 - Reg success;
    1 - Auth success;
    */

    public int authChecker() throws NoSuchAlgorithmException, IOException {
        Reader reader = new Reader();
        String[] data = reader.read();
        if (data == null) return 0;
        for (int i = 0; i < data.length; i++) {
            if(data[i] != null) {
                String possibleData = data[i];
                String[] splitedLogAndPass = possibleData.split("@");
                if (splitedLogAndPass[0].equals(login)) {
                    if (splitedLogAndPass[1].equals(password)) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            } else {
                registrationOfNewUser();
                return 0;
            }
        }
        registrationOfNewUser();
        return 0;
    }
    public void registrationOfNewUser() throws NoSuchAlgorithmException, IOException {
        Writer.write("Data.txt", "#" + login + "@" + password);

    }
}