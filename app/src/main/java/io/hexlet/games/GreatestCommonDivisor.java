package io.hexlet.games;

import io.hexlet.util.Util;

public final class GreatestCommonDivisor extends Game<String> {
    @Override
    public QuestionAndAnswer<String> getQuestionAndAnswer() {
        final int a = Util.getRandomNumber(1, 100);
        final int b = Util.getRandomNumber(1, 100);
        final int gcd = findGcd(a, b);

        return new QuestionAndAnswer<>(a + " " + b, String.valueOf(gcd));
    }

    private int findGcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return findGcd(b, a % b);
    }
}
