package io.hexlet.view;

import io.hexlet.games.GameType;

public class EngViewMessages implements ViewMessages {

    @Override
    public String getGreetMessage() {
        return "Welcome to the Brain Games!\nMay I have your name?";
    }

    @Override
    public String getHelloMessage(String userName) {
        return "Hello, " + userName + "!";
    }

    @Override
    public String getMenuIntroMessage() {
        return "Please enter the game number and press Enter.";
    }

    @Override
    public String getMenuOptionTitle(Menu.Option option) {
        switch (option) {
            case GREET -> {
                return "Greet";
            }
            case EVEN -> {
                return "Even";
            }
            case CALC -> {
                return "Calc";
            }
            case GCD -> {
                return "GCD";
            }
            case PROGRESSION -> {
                return "Progression";
            }
            case PRIME -> {
                return "Prime";
            }
            case EXIT -> {
                return "Exit";
            }
            default -> {
                return "Unhandled menu option";
            }
        }
    }

    @Override
    public String getInvalidMenuOptionMessage() {
        return "Invalid input!";
    }

    @Override
    public String getRulesMessage(GameType gameType) {

        switch (gameType) {
            case EVEN -> {
                return "Answer 'yes' if the number is even, otherwise answer 'no'.";
            }
            case CALC -> {
                return "What is the result of the expression?";
            }
            case GCD -> {
                return "Find the greatest common divisor of given numbers.";
            }
            case PROGRESSION -> {
                return "What number is missing in the progression?";
            }
            case PRIME -> {
                return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
            }
            default -> {
                return "Unhandled game type";
            }
        }
    }

    @Override
    public String getQuestionMessage(String question) {
        return "Question: " + question + "\nYour answer: ";
    }

    @Override
    public String getWrongAnswerMessage(String wrongAnswer, String correctAnswer) {
        return "'" + wrongAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.";
    }

    @Override
    public String getCorrectAnswerMessage() {
        return "Correct!";
    }

    @Override
    public String getWinMessage(String userName) {
        return "Congratulations, " + userName + "!";
    }

    @Override
    public String getLostMessage(String userName) {
        return "Let's try again, " + userName + "!";
    }
}
