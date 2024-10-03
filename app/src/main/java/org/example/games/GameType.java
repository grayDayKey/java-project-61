package org.example.games;

public enum GameType {
    EVEN,
    CALC,
    GCD,
    PROGRESSION,
    PRIME;

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

        if (game instanceof Prime) {
            return PRIME;
        }

        return EVEN;
    }
}
