package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import logic.HomeWalker;
import util.RandomGenerator;

public class TestHomeWalker {
	
	private Random testRand;

	@Before
	public void setUp() throws Exception {
		long seed = 89631139L;
		RandomGenerator.setSeed(seed);
		testRand = new Random(seed);
	}

	@Test
	public void testMove() {
		HomeWalker testWalker = new HomeWalker("Kaiba", 3000);
		assertEquals(0, testWalker.getPosition());
		int testPosition = 0;
		for (int i = 0; i < 10; i++) {
			testWalker.move();
			testPosition += testWalker.getSpeed() + testRand.nextInt(200) + testRand.nextInt(200);
			assertEquals("Kaiba", testWalker.getName());
			assertEquals(3000, testWalker.getSpeed());
			assertEquals(testPosition, testWalker.getPosition());
		}
	}

}
