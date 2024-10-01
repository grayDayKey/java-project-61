package org.example.games;

public enum GameType {
    EVEN,
    CALC;

    public static GameType of(Game<?> game) {
        if (game instanceof Calc) {
            return CALC;
        }

        return EVEN;
    }
}
