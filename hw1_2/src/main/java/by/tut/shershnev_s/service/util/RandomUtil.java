package by.tut.shershnev_s.service.util;

import java.util.Random;

public class RandomUtil {

    private static final Random random = new Random();

    public static int getRandomNumberInRange(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    public static int getRandomNumber() {
        return random.nextInt();
    }
}
