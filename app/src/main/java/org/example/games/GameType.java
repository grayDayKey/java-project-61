package org.example.games;

public enum GameType {
    EVEN,
    CALC,
    GCD,
    PROGRESSION;

    public static GameType of(Game<?> game) {
        if (game instanceof Calc) {
            return CALC;
        }

        if (game instanceof GreatestCommonDivisor) {
            return GCD;
        }

        if (game instanceof Progression) {
            return PROGRESSION;
        }

        return EVEN;
    }
}
