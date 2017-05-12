package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws Throwable {
        ServerSocket server = new ServerSocket(44444);
        int count = 0;
        while(true){
            Socket s = server.accept();
            count++;
            System.out.println("Client #" + count + " connected");
            new Thread(new SocketProcessor(s)).start();
        }
    }
    public static class SocketProcessor implements Runnable{
        private String[] data;
        public Socket socket;
        private InputStream is;
        private OutputStream os;
        private String result;
        public static String login;

        public SocketProcessor(Socket s) throws Throwable{
            this.socket = s;
            this.is = s.getInputStream();
            this.os = s.getOutputStream();
        }

        @Override
        public void run() {
            try {
                readInputHeaders();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            if(data[0].equals("nums")) {
                for(String x : data){
                    System.out.println(x);
                }
                CollectionForPriority math = new CollectionForPriority();
                result = math.PriorityCalc(data[1]);
                writeResponse(result);
                try {
                    Writer.write("Math.txt", data[1] + " = " + result + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if(data[0].equals("auth")){
                login = data[1];
                Authentication auth = new Authentication(data[1], data[2]);
                try {
                    writeResponse(String.valueOf(auth.authChecker()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    if (auth.authChecker() == 0){
                        Writer.write("Data.txt", "#" + data[1] + "@" + data[2] + "\n");
                    }
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                writeResponse("wrong Data");
            }
        }
        private void readInputHeaders() throws Throwable {
            DataInputStream in = new DataInputStream(is);
            String s = in.readUTF();
            data = s.split("@");
        }
        private void writeResponse(String s){
            try {
                DataOutputStream out = new DataOutputStream(os);
                out.writeUTF(s);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
