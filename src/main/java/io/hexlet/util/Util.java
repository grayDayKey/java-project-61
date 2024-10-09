package io.hexlet.util;

import java.util.Random;

public final class Util {

    private Util() {

    }

    public static int getRandomNumber(int origin, int bound) {
        return new Random().nextInt(origin, bound);
    }

    public static int[] getProgression(int size, int step, int start) {
        final int[] progression = new int[size];

        for (int i = 0, j = start; i < size; i++, j = j + step) {
            progression[i] = j;
        }

        return progression;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
