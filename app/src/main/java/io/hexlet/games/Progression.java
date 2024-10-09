package io.hexlet.games;

import io.hexlet.util.Util;

public final class Progression extends Game<String> {

    @Override
    public QuestionAndAnswer<String> getQuestionAndAnswer() {

        final int size = Util.getRandomNumber(5, 11);
        final int step = Util.getRandomNumber(2, 101);
        final int firstStep = Util.getRandomNumber(1, 101);

        final int skipped = Util.getRandomNumber(0, size);

        final int[] progression = Util.getProgression(size, step, firstStep);

        final StringBuilder questionBuilder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            if (i == skipped) {
                questionBuilder.append(".. ");
            } else {
                questionBuilder.append(progression[i]).append(" ");
            }
        }

        final String question = questionBuilder.toString();
        final String answer = String.valueOf(progression[skipped]);

        return new QuestionAndAnswer<>(question, answer);
    }
}
