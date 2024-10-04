package org.example.view;

import org.example.games.GameType;

public interface ViewMessages {

    String getGreetMessage();

    String getHelloMessage(String userName);

    String getMenuIntroMessage();

    String getMenuOptionTitle(Menu.Option option);

    default String getMenuMessage() {
        final Menu.Option[] menuOptions = Menu.Option.values();
        final StringBuilder sb = new StringBuilder();

        sb.append(getMenuIntroMessage());

        for (Menu.Option option : menuOptions) {
            sb.append(System.lineSeparator());
            sb.append(getMenuOptionMessage(option));
        }

        return sb.toString();
    }


    default String getMenuOptionMessage(Menu.Option option) {
        return String.format("%d - %s", option.number, getMenuOptionTitle(option));
    }

    String getInvalidMenuOptionMessage();

    String getRulesMessage(GameType gameType);

    String getQuestionMessage(String question);

    String getWrongAnswerMessage(String wrongAnswer, String correctAnswer);

    String getCorrectAnswerMessage();

    String getWinMessage(String userName);

    String getLostMessage(String userName);
}
