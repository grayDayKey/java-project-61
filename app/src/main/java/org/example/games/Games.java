package org.example.games;

import java.io.InputStream;
import java.util.Scanner;

public class Games {

    private static final int EXIT = 0;
    private static final int IDLE = -1;
    private static final String EXIT_MESSAGE = "Exit";
    private static final String INVALID_INPUT_MESSAGE = "Invalid input!";

    private static final String INSTRUCTIONS_MESSAGE = "Please enter the game number and press Enter.";

    private final Game[]  games = {new Greet(), new Even()};

    public void start(InputStream inputStream) {
        int gameIndex = IDLE;

        while (gameIndex == IDLE) {
            System.out.println(getInstructionsMessage());
            System.out.println(getGamesMenuMessage());
            try {
                final int number = requestGameNumber();

                if (number < 0 || number >= games.length) {
                    throw new IllegalArgumentException();
                }

                if (number == EXIT) {
                    return;
                }

                gameIndex = number - 1;
            } catch (Exception e) {
                System.out.println(INVALID_INPUT_MESSAGE);
            }
        }

        games[gameIndex].run(inputStream);
    }

    private String getInstructionsMessage() {
        return INSTRUCTIONS_MESSAGE;
    }

    private String getGamesMenuMessage() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < games.length; i++) {
            builder.append(getGameMenuOptionMessage(i));
            builder.append(System.getProperty("line.separator"));
        }

        builder.append(getMenuOption(0, EXIT_MESSAGE));

        return builder.toString();
    }

    private String mapGameTypeToGameName(Game game) {
        if (game instanceof Even) {
            return "Even";
        } else if (game instanceof Greet) {
            return "Greet";
        }

        return "Unknown Game";
    }

    private String getMenuOption(int optionNumber, String optionName) {
        return optionNumber + " - " + optionName;
    }

    private String getGameMenuOptionMessage(int gameNumber) {
        assert gameNumber > 0 && gameNumber < games.length;
        final Game game = games[gameNumber];

        return getMenuOption(gameNumber + 1, mapGameTypeToGameName(game));
    }

    private int requestGameNumber() {
        return new Scanner(System.in).nextInt();
    }
}
