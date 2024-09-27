package org.example.games;

import java.io.InputStream;

public abstract class Game {

    static int defaultWinCondition = 3;
    static int defaultLoseCondition = 1;

    public Game() {
        this(defaultWinCondition, defaultLoseCondition);
    }

    public Game(int winCondition, int loseCondition) {
        this.winCondition = winCondition;
        this.loseCondition = loseCondition;
    }

    final int winCondition;
    final int loseCondition;

    int correctAnswers;
    int wrongAnswers;

    public abstract String getRules();

    public abstract int getQuestion();

    public abstract boolean isAnswerValid(int question, String answer);

    public abstract String applyAnswer(int question, String answer);

    public boolean isWinConditionsAchieved() {
        return correctAnswers >= winCondition;
    }

    public boolean isLoseConditionsAchieved() {
        return wrongAnswers >= loseCondition;
    }
}
