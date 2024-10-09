/*
 * This source file was generated by the Gradle 'init' task
 */
package io.hexlet;

import io.hexlet.games.Game;
import io.hexlet.games.Calc;
import io.hexlet.games.Progression;
import io.hexlet.games.GameType;
import io.hexlet.games.GreatestCommonDivisor;
import io.hexlet.games.Even;
import io.hexlet.games.Prime;
import io.hexlet.games.QuestionAndAnswer;
import io.hexlet.view.CliView;
import io.hexlet.view.View;
import io.hexlet.view.EngViewMessages;
import io.hexlet.view.ViewMessages;
import io.hexlet.view.Menu;

import java.util.Optional;

public final class Application {

    private Application() {

    }

    public static void main(final String[] args) {
        final ViewMessages messages = new EngViewMessages();
        final View view = new CliView(messages);

        final Optional<Menu.Option> maybeMenuOption = view.showMenu();

        if (maybeMenuOption.isEmpty()) {
            return;
        }

        final Menu.Option menuOption = maybeMenuOption.get();

        if (menuOption == Menu.Option.EXIT) {
            return;
        }

        if (menuOption == Menu.Option.GREET) {
            view.showGreetings();
            return;
        }

        final Game<?> game;

        if (menuOption == Menu.Option.CALC) {
            game = new Calc();
        } else if (menuOption == Menu.Option.GCD) {
            game = new GreatestCommonDivisor();
        } else if (menuOption == Menu.Option.PROGRESSION) {
            game = new Progression();
        } else if (menuOption == Menu.Option.PRIME) {
            game = new Prime();
        } else {
            game = new Even();
        }

        final String userName = view.showGreetings();
        view.showRules(GameType.of(game));

        while (!game.isWinConditionsAchieved() && !game.isLoseConditionsAchieved()) {
            final QuestionAndAnswer<?> questionAndAnswer = game.getQuestionAndAnswer();

            final String userAnswer = view.showQuestion(questionAndAnswer.question().toString());
            final boolean isAnswerCorrect = game.handleUserAnswer(questionAndAnswer, userAnswer);

            view.showAnswerResultMessage(isAnswerCorrect, userAnswer, questionAndAnswer.correctAnswer());
        }

        view.showGameResult(game.isWinConditionsAchieved(), userName);
    }
}
