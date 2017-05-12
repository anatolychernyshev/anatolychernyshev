package com.company.net;

import java.io.*;
import java.net.Socket;

public class CreateRequest {

    private static InputStream sin = null;
    private static OutputStream sout = null;
    private static DataInputStream in = null;
    private static DataOutputStream out = null;
    private static Socket clientSocket = null;

    public static String getRequest(String request) throws IOException {

        connectToServer();
        out.writeUTF(request);
        out.flush();
        String response = in.readUTF();
        System.out.println(response);
        return response;

    }

    private static void connectToServer() throws IOException {
        clientSocket = new Socket("localhost", 44444);
        sin = clientSocket.getInputStream();
        sout = clientSocket.getOutputStream();
        in = new DataInputStream(sin);
        out = new DataOutputStream(sout);
    }
}
