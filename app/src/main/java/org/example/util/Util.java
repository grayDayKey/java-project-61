package org.example.util;

import java.util.Random;

public class Util {

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
}
