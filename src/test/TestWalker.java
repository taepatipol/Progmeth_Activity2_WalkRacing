package test;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import logic.Walker;
import util.RandomGenerator;

public class TestWalker {
	
	private Random testRand;

	@Before
	public void setUp() throws Exception {
		long seed = 46986414L;
		RandomGenerator.setSeed(seed);
		testRand = new Random(seed);
	}

	@Test
	public void testMove() {
		Walker testWalker = new Walker("Yugi", 2500);
		assertEquals(0, testWalker.getPosition());
		int testPosition = 0;
		for (int i = 0; i < 10; i++) {
			testWalker.move();
			testPosition += testWalker.getSpeed() + testRand.nextInt(200);
			assertEquals("Yugi", testWalker.getName());
			assertEquals(2500, testWalker.getSpeed());
			assertEquals(testPosition, testWalker.getPosition());
		}
	}

}
