package util;

import java.util.Random;

public class RandomGenerator {
	private static Random rand = new Random(9999L);

	/**
	 * Generates a random number in the range [from, to)
	 * @param from	The first possible number
	 * @param to	The number after the last possible number
	 */
	public static int random(int from, int to)
	{
		return from + RandomGenerator.rand.nextInt(to - from);
	}
	
	/**
	 * Reset the random number generator's seed.
	 * Used for testing only. Students please don't use this method.
	 *
	 * @param seed	The new seed for the RNG
	 */
	public static void setSeed(long seed) {
		rand = new Random(seed);
	}
}
