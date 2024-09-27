package org.example;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Cli {
    private static final String WELCOME_MESSAGE = "Welcome to the Brain Games!";
    private static final String GREET_MESSAGE = "May I have your name?";
    private static final String HELLO_MESSAGE = "Hello, ";

    private static final String MENU_INTRODUCING_MESSAGE = "Please enter the game number and press Enter.";

    public enum MenuOption {
        EXIT(0, "Exit"),
        GREET(1, "Greet"),
        EVEN(2, "Even"),
        Calc(3, "Calc");

        MenuOption(int number, String title) {
            this.title = title;
            this.number = number;
        }

        final int number;
        final String title;

        public static Optional<MenuOption> of(int maybeOptionNumber) {
            return Arrays.stream(MenuOption.values()).filter((el) -> el.number == maybeOptionNumber).findFirst();
        }

        @Override
        public String toString() {
            return String.format("%d - %s", number, title);
        }
    }

    public static String greet() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println(GREET_MESSAGE);
        final String name = readName();
        System.out.println(HELLO_MESSAGE + name + "!");

        return name;
    }

    private static String readName() {
        return new Scanner(System.in).nextLine();
    }

    public static void printMenu() {
        final MenuOption[] menuOptions = MenuOption.values();
        final StringBuilder sb = new StringBuilder();

        sb.append(MENU_INTRODUCING_MESSAGE);
        sb.append(System.lineSeparator());

        for (int i = 1; i < menuOptions.length; i++) {
            sb.append(menuOptions[i].toString());
            sb.append(System.lineSeparator());
        }

        sb.append(menuOptions[0].toString());

        System.out.println(sb);
    }
}
