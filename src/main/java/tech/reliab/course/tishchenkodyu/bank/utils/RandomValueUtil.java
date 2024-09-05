package tech.reliab.course.tishchenkodyu.bank.utils;

import java.util.Random;

public class RandomValueUtil {
    public int getRandomIntInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
}
