package io.hexlet.games;

import io.hexlet.util.Util;

public class Prime extends Game<Integer> {
    @Override
    public QuestionAndAnswer<Integer> getQuestionAndAnswer() {
        final int randomNumber = Util.getRandomNumber(1, 1000);
        return new QuestionAndAnswer<>(randomNumber, Util.isPrime(randomNumber) ? "yes" : "no");
    }
}
