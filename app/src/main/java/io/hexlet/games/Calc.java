package io.hexlet.games;

import io.hexlet.util.Util;

import java.util.Arrays;
import java.util.Optional;

public final class Calc extends Game<String> {

    public enum Operator {
        PLUS("+"),
        MINUS("-"),
        PROD("*");

        private final String symbol;

        Operator(String s) {
            symbol = s;
        }

        public static Operator getRandom() {
            return values()[Util.getRandomNumber(0, values().length)];
        }

        public static Optional<Operator> of(String symbol) {
            return Arrays.stream(values()).filter(operator -> symbol.equals(operator.symbol)).findFirst();
        }
    }

    @Override
    public QuestionAndAnswer<String> getQuestionAndAnswer() {
        final int a = Util.getRandomNumber(1, 100);
        final int b = Util.getRandomNumber(1, 100);
        final Operator operator = Operator.getRandom();

        final String question = String.format("%d %s %d", a, operator.symbol, b);
        final String correctAnswer = String.valueOf(compute(a, b, operator));

        return new QuestionAndAnswer<>(question, correctAnswer);
    }

    private int compute(int a, int b, Operator operator) {
        switch (operator) {
            case PLUS -> {
                return a + b;
            }
            case MINUS -> {
                return a - b;
            }
            case PROD -> {
                return a * b;
            }
            default -> throw new IllegalArgumentException();
        }
    }
}
