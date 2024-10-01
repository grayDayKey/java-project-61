package org.example.view;

import org.example.games.GameType;

public class EngViewMessages implements ViewMessages {

    @Override
    public String getGreetMessage() {
        return "Welcome to the Brain Games!\nMay I have your name?";
    }

    @Override
    public String getHelloMessage(String userName) {
        return String.format("Hello, $s!", userName) ;
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
            case EXIT -> {
                return "Exit";
            }
        }

        return "Unhandled menu option";
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
        }

        return "Unhandled game type";
    }

    @Override
    public String getQuestionMessage(String question) {
        return "Question: " + question;
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
