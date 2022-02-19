package com.vighnesh.demo1.io;

import java.util.Scanner;

public class ConsoleIO {

    private final Scanner scanner;


    public ConsoleIO() {
        this.scanner = new Scanner(System.in);
    }

    public int scanInt() {
        return scanner.nextInt();
    }

    public String scanLine() {
        return scanner.nextLine();
    }

    public String[] scanLineToken() {
        String str = scanner.nextLine();
        return str.split(" ");
    }
}
