package org.example.games;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class Even extends Game {

    private static final String YES_ANSWER = "yes";
    private static final String NO_ANSWER = "no";

    private Random random;

    @Override
    public String applyAnswer(int question, String answer) {
        final boolean isCorrectAnswer = isCorrectAnswer(question, answer);

        if (isCorrectAnswer) {
            correctAnswers++;
        } else {
            wrongAnswers++;
        }

        return isCorrectAnswer ? "Correct!" : getWrongAnswerMessage(answer);
    }

    @Override
    public String getRules() {
        return "Answer '" + YES_ANSWER + "' if the number is even, otherwise answer '" + NO_ANSWER + "'.";
    }

    @Override
    public int getQuestion() {
        return getRandomNumber();
    }

    @Override
    public boolean isAnswerValid(int question, String answer) {
        answer = answer.toLowerCase();

        return answer.equals(YES_ANSWER) || answer.equals(NO_ANSWER);
    }

    private String getWrongAnswerMessage(String wrongAnswer) {
        final String correctAnswer = wrongAnswer.equals(YES_ANSWER) ? NO_ANSWER : YES_ANSWER;

        return "'" + wrongAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.";
    }

    private String getWinMessage(String userName) {
        return "Congratulations, " + userName + "!";
    }

    private int getRandomNumber() {
        if (random == null) {
            random = new Random();
        }

        return random.nextInt(0, 100);
    }

    boolean isCorrectAnswer(int randomNumber, String answer) {
        final boolean isEven = randomNumber % 2 == 0;

        return isEven && answer.equals(YES_ANSWER) || !isEven && answer.equals(NO_ANSWER);
    }
}
