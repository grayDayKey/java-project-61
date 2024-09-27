package org.example;

import org.example.games.Even;
import org.example.games.Game;

import java.util.Optional;
import java.util.Scanner;

public class GameEngine {
    private Scanner scanner;

    public void run() {
        final String userName = Cli.greet();
        final Cli.MenuOption chosenMenuOption = requestMenuOption();
        handleChosenMenuOption(chosenMenuOption, userName);
    }

    private Cli.MenuOption requestMenuOption() {
        try {
            Cli.printMenu();
            final int menuIndex = new Scanner(System.in).nextInt();
            final Optional<Cli.MenuOption> maybeMenuOption = Cli.MenuOption.of(menuIndex);

            if (maybeMenuOption.isPresent()) {
                return maybeMenuOption.get();
            }
        } catch (Exception e) {
            output("Wrong input!");
        }

        return requestMenuOption();
    }

    private void handleChosenMenuOption(Cli.MenuOption menuOption, String userName) {
        if (menuOption == Cli.MenuOption.EXIT) {
            return;
        }

        final Game chosenGame = choseGame(menuOption);
        final boolean isWinConditionsAchieved = runChosenGame(chosenGame);
        output(getGameResultMessage(userName, isWinConditionsAchieved));
    }

    private Game choseGame(Cli.MenuOption menuOption) {
        return new Even();
    }

    private boolean runChosenGame(Game chosenGame) {
        final String gameRules = chosenGame.getRules();

        output(gameRules);

        while (isGameSessionActive(chosenGame)) {
            int question = chosenGame.getQuestion();
            String answer = "";
            boolean isAnswerValid = false;

            while (!isAnswerValid) {
                answer = requestAnswer(question);
                isAnswerValid = chosenGame.isAnswerValid(question, answer);

                if (!isAnswerValid) {
                    output(gameRules);
                }
            }

            final String resultMessage = chosenGame.applyAnswer(question, answer);
            output(resultMessage);
        }

        return chosenGame.isWinConditionsAchieved();
    }

    private boolean isGameSessionActive(Game activeGame) {
        return !activeGame.isWinConditionsAchieved() && !activeGame.isLoseConditionsAchieved();
    }

    private void output(String message) {
        System.out.println(message);
    }

    private String getGameResultMessage(String userName, boolean isWinConditionsAchieved) {
        return (isWinConditionsAchieved ? "Congratulations, " : "Let's try again, ") + userName + "!";
    }

    private String requestAnswer(int question) {
        output("Question: " + question);

        if (scanner == null) {
            scanner = new Scanner(System.in);
        }

        return scanner.next();
    }
}
