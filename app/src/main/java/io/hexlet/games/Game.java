package io.hexlet.games;

public abstract class Game<T> {

    final static int DEFAULT_WIN_CONDITION = 3;
    final static int DEFAULT_LOSE_CONDITION = 1;

    public Game() {
        this(DEFAULT_WIN_CONDITION, DEFAULT_LOSE_CONDITION);
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
