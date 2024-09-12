package org.example;

import java.util.Scanner;

public final class Cli {

    private Cli() {

    }

    public static void greet() {
        final String name;

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        try (Scanner scanner = new Scanner(System.in)) {
            name = scanner.next();
        }

        System.out.println("Hello, " + name + "!");
    }
}
