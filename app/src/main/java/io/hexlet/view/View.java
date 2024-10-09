package io.hexlet.view;

import io.hexlet.games.GameType;

import java.util.Optional;

public interface View {

    String showGreetings();

    Optional<Menu.Option> showMenu();

    void showRules(GameType gameType);

    String showQuestion(String question);

    void showAnswerResultMessage(boolean isCorrectAnswer, String answer, String correctAnswer);

    void showGameResult(boolean isWon, String userName);
}
