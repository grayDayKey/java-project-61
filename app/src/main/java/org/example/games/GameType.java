package org.example.games;

public enum GameType {
    EVEN,
    CALC,
    GCD;

    public static GameType of(Game<?> game) {
        if (game instanceof Calc) {
            return CALC;
        }

        if (game instanceof GreatestCommonDivisor) {
            return GCD;
        }

        return EVEN;
    }
}
