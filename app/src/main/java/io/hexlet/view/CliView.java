package io.hexlet.view;

import io.hexlet.games.GameType;

import java.util.Optional;
import java.util.Scanner;

public class CliView implements View {

    private final ViewMessages messages;
    private final Scanner scanner;

    public CliView(ViewMessages messages) {
        this.messages = messages;
        scanner = new Scanner(System.in);
    }

    @Override
    public String showGreetings() {
        System.out.println(messages.getGreetMessage());

        final String userName = scanner.next();

        System.out.println(messages.getHelloMessage(userName));

        return userName;
    }

    @Override
    public Menu.Option showMenu() {
        System.out.println(messages.getMenuMessage());
        try {
            final Optional<Menu.Option> option = Menu.Option.of(scanner.nextInt());

            if (option.isPresent()) {
                return option.get();
            }
        } catch (Exception e) {
            System.out.println(messages.getInvalidMenuOptionMessage());
        }

        return showMenu();
    }

    @Override
    public void showRules(GameType gameType) {
        System.out.println(messages.getRulesMessage(gameType));
    }

    @Override
    public String showQuestion(String question) {
        System.out.print(messages.getQuestionMessage(question));
        return scanner.next();
    }

    @Override
    public void showAnswerResultMessage(boolean isCorrectAnswer, String answer, String correctAnswer) {
        System.out.println(isCorrectAnswer
                ? messages.getCorrectAnswerMessage()
                : messages.getWrongAnswerMessage(answer, correctAnswer)
        );
    }

    @Override
    public void showGameResult(boolean isWon, String userName) {
        System.out.println(isWon ? messages.getWinMessage(userName) : messages.getLostMessage(userName));
    }
}
