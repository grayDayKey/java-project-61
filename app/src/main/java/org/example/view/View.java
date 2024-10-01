package org.example.view;

import org.example.games.GameType;

public interface View {

    String showGreetings();

    Menu.Option showMenu();

    void showRules(GameType gameType);

    String showQuestion(String question);

    void showAnswerResultMessage(boolean isCorrectAnswer, String answer, String correctAnswer);

    void showGameResult(boolean isWon, String userName);
}
