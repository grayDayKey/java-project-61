package io.hexlet.games;

public abstract class Game<T> {

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

    public abstract QuestionAndAnswer<T> getQuestionAndAnswer();

    public boolean handleUserAnswer(QuestionAndAnswer<?> questionAndAnswer, String userAnswer) {
        final boolean isCorrect = questionAndAnswer.correctAnswer().equals(userAnswer);

        if (isCorrect) {
            correctAnswers++;
        } else {
            wrongAnswers++;
        }

        return isCorrect;
    }

    public boolean isWinConditionsAchieved() {
        return correctAnswers >= winCondition;
    }

    public boolean isLoseConditionsAchieved() {
        return wrongAnswers >= loseCondition;
    }
}
