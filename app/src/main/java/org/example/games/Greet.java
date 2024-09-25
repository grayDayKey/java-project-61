package org.example.games;

import java.io.InputStream;
import java.util.Scanner;

public class Greet implements Game {

    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";
    private static final String GREET_MESSAGE = "May I have your name?";
    private static final String HELLO_MESSAGE = "Hello, ";

    @Override
    public void run(InputStream inputStream) {
        greet(inputStream);
    }

    public static String greet(InputStream inputStream) {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(GREET_MESSAGE);
        final String name = readName(inputStream);
        System.out.println(HELLO_MESSAGE + name + "!");

        return name;
    }

    private static String readName(InputStream inputStream) {
        return new Scanner(inputStream).nextLine();
    }
}
