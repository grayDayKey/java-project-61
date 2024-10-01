package org.example.games;

import org.example.util.Util;

import java.util.Arrays;
import java.util.Optional;

public class Calc extends Game<String> {

    public enum Operator {
        PLUS("+"),
        MINUS("-"),
        PROD("*");

        final String symbol;

        Operator(String symbol) {
            this.symbol = symbol;
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
        }

        throw new IllegalArgumentException();
    }
}
