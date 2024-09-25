package org.example.games;

import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class Even implements Game {

    private static final int TARGET_CORRECT_ANSWERS = 3;

    private static final String YES_ANSWER = "yes";
    private static final String NO_ANSWER = "no";

    private int correctAnswers;

    private Random random;

    @Override
    public void run(InputStream inputStream) {
        final String userName = Greet.greet(inputStream);

        while (isGameSessionActive()) {
            String answer = "";
            int randomNumber = getRandomNumber();
            boolean validAnswer = false;

            while (!validAnswer) {
                System.out.println(getRulesMessage());
                String question = getQuestionMessage(randomNumber);
                System.out.println(question);
                answer = requestAnswer(inputStream);

                validAnswer = isValidAnswer(answer);
            }

            if (isCorrectAnswer(randomNumber, answer)) {
                correctAnswers++;
                System.out.println(getCorrectAnswerMessage());
            } else {
                System.out.println(getWrongAnswerMessage(answer));
            }
        }

        if (isWin()) {
            System.out.println(getWinMessage(userName));
        }
        stop();
    }

    private void stop() {
        correctAnswers = 0;
    }


    private String getRulesMessage() {
        return "Answer '" + YES_ANSWER + "' if the number is even, otherwise answer '" + NO_ANSWER + "'.";
    }

    private String getQuestionMessage(int randomNumber) {
        return "Question: " + randomNumber;
    }

    private String getCorrectAnswerMessage() {
        return "Correct!";
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

    private void outputQuestionMessage() {

    }

    private String requestAnswer(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextLine();
    }

    private boolean isGameSessionActive() {
        return !isWin();
    }

    private boolean isValidAnswer(String answer) {
        answer = answer.toLowerCase();

        return answer.equals(YES_ANSWER) || answer.equals(NO_ANSWER);
    }

    private boolean isCorrectAnswer(int randomNumber, String answer) {
        final boolean isEven = isEven(randomNumber);

        return isEven && answer.equals(YES_ANSWER) || !isEven && answer.equals(NO_ANSWER);
    }

    private boolean isEven(int randomNumber) {
        return randomNumber % 2 == 0;
    }

    private boolean isWin() {
        return correctAnswers >= TARGET_CORRECT_ANSWERS;
    }
}
