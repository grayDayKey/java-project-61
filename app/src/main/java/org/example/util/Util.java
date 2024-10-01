package org.example.util;

import java.util.Random;

public class Util {

    private Util() {

    }

    public static int getRandomNumber(int origin, int bound) {
        return new Random().nextInt(origin, bound);
    }
}
