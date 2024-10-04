package org.example.view;

import java.util.Arrays;
import java.util.Optional;

public interface Menu {

    enum Option {
        GREET(1),
        EVEN(2),
        CALC(3),
        GCD(4),
        PROGRESSION(5),
        PRIME(6),
        EXIT(0);

        Option(int number) {
            this.number = number;
        }

        final int number;

        public static Optional<Option> of(int maybeOptionNumber) {
            return Arrays.stream(Option.values()).filter((el) -> el.number == maybeOptionNumber).findFirst();
        }
    }
}
