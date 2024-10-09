package io.hexlet.games;

public abstract class Game<T> {

    static final int DEFAULT_WIN_CONDITION = 3;
    static final int DEFAULT_LOSE_CONDITION = 1;

    public Game() {
        this(DEFAULT_WIN_CONDITION, DEFAULT_LOSE_CONDITION);
    }

    public Game(int win, int lose) {
        winCondition = win;
        loseCondition = lose;
    }

    private final int winCondition;
    private final int loseCondition;

    private int correctAnswers;
    private int wrongAnswers;

    public abstract QuestionAndAnswer<T> getQuestionAndAnswer();

    /**
     * <p>Checks if user answered correct and handle it's according to game win condition logic.</p>
     * @param questionAndAnswer contains question and correct answer to it
     * @param userAnswer the answer of user
     * @return true if userAnswer is correct otherwise false
     */
    public boolean handleUserAnswer(QuestionAndAnswer<?> questionAndAnswer, String userAnswer) {
        final boolean isCorrect = questionAndAnswer.correctAnswer().equals(userAnswer);

        if (isCorrect) {
            correctAnswers++;
        } else {
            wrongAnswers++;
        }

        return isCorrect;
    }

    /**
     * <p>The method allows you to determine if the game is won.</p>
     * @return true if win conditions achieved otherwise false
     */
    public boolean isWinConditionsAchieved() {
        return correctAnswers >= winCondition;
    }

    /**
     * <p>The method allows you to determine if the game is lost.</p>
     * @return  true if lose conditions achieved otherwise false
     */
    public boolean isLoseConditionsAchieved() {
        return wrongAnswers >= loseCondition;
    }
}
