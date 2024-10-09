package io.hexlet.games;

import io.hexlet.util.Util;

public final class Even extends Game<Integer> {

    private static final String YES_ANSWER = "yes";
    private static final String NO_ANSWER = "no";

    @Override
    public QuestionAndAnswer<Integer> getQuestionAndAnswer() {
        final int randomNumber = Util.getRandomNumber(1, 100);
        final String answer = randomNumber % 2 == 0 ? YES_ANSWER : NO_ANSWER;
        return new QuestionAndAnswer<>(randomNumber, answer);
    }
}
