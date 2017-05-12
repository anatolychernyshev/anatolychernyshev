package com.company;

import java.security.NoSuchAlgorithmException;

public class Parser {

    public String authString(String login, char [] password) throws NoSuchAlgorithmException {
        String pass = Encoder.crypt(password);
        String request = "auth" + "@" + login + "@" + pass;
        return request;
    }

    public String calcString(String numbers){
        String request = "nums" + "@" + numbers;
        return request;
    }


}
