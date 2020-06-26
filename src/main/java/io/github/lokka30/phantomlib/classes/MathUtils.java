package io.github.lokka30.phantomlib.classes;

import java.util.concurrent.ThreadLocalRandom;

@SuppressWarnings("unused")
public class MathUtils {

    public MathUtils() {
    }

    /**
     * Generate a random integer
     *
     * @return the random integer
     */
    public int generateRandomInt() {
        return ThreadLocalRandom.current().nextInt();
    }

    /**
     * Generate a random double
     *
     * @return the random double
     */
    public double generateRandomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }

    /**
     * Generate a random integer between the min and max params
     *
     * @param min the minimum value allowed to be generated
     * @param max the maximum value allowed to be generated
     * @return the random integer
     */
    public int generateRandomIntBetween(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    /**
     * Generate a random double between the min and max params
     *
     * @param min the minimum value allowed to be generated
     * @param max the maximum value allowed to be generated
     * @return the random double
     */
    public double generateRandomDoubleBetween(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    /**
     * Return if the chance out of 100 was successful or not.
     *
     * @param chanceOutOf100 the chance from 0-100
     * @return if the random integer generated is higher than the chance specified
     */
    public boolean chanceOf(int chanceOutOf100) {
        return generateRandomIntBetween(0, 100) >= chanceOutOf100;
    }

    /**
     * Return if the chance out of 100 was successful or not.
     *
     * @param chanceOutOf100 the chance from 0-100
     * @return if the random integer generated is higher than the chance specified
     */
    public boolean chanceOf(double chanceOutOf100) {
        return generateRandomDoubleBetween(0, 100) >= chanceOutOf100;
    }
}
