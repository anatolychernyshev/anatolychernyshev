package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Item first = null;
    static Item last = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("What do u want to do?" + "\n" + "1: Push" + "\n" + "2: Pop" + "\n" + "3: PrintAll");
            int input = Integer.parseInt(br.readLine());
            switch (input) {
                case 1:
                    System.out.print("Enter the number: ");
                    int a = Integer.parseInt(br.readLine());
                    push(a);
                    System.out.println("Added" + "\n");
                    break;
                case 2:
                    System.out.println("Last is: " + last.value);
                    pop();
                    System.out.println("Deleted" + "\n");
                    break;
                case 3:
                    System.out.println("Printed list:");
                    printAll();
                    break;
            }
        }
    }

    public static void setLast(int a){
        Item item = new Item(a);
        if (first == null) {
            first = item;
            last = item;
        }
        else {
            Item lastNode = first;
            while (lastNode.next != null)
                lastNode = lastNode.next;
            lastNode.next = item;
            item.prev = lastNode;
            last = item;
        }
    }

    public static void deleteLast(){
        Item x = last;
        last = x.prev;
        x.prev.next = null;
    }
    public static void push(int x){
        setLast(x);
    }

    public static void pop(){
        deleteLast();
    }

    public static void printAll(){
        System.out.println(first.value);
        Item lastNode = first.next;
        while (lastNode.next != null){
            System.out.println(lastNode.value);
            lastNode = lastNode.next;
        }
        System.out.println(lastNode.value);
    }
}