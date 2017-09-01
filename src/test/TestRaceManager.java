package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import logic.HomeWalker;
import logic.RaceManager;
import logic.Walker;
import util.RandomGenerator;

public class TestRaceManager {
	
	private ArrayList<Walker> testWalkers;
	private final long seed = 88888888L;

	@Before
	public void setUp() throws Exception {
		testWalkers = new ArrayList<>();
		testWalkers.add(new Walker("A", 200));
		testWalkers.add(new Walker("B", 300));
		testWalkers.add(new Walker("C", 400));
		testWalkers.add(new Walker("D", 500));
		testWalkers.add(new HomeWalker("E", 600));
	}

	@Test
	public void testUpdate() {
		RaceManager testRaceManager = new RaceManager(cloneWalkers());

		ArrayList<Walker> refWalkers = cloneWalkers();
		RandomGenerator.setSeed(seed);
		testRaceManager.update();
		RandomGenerator.setSeed(seed);
		List<Walker> currentTestWalkers = testRaceManager.getWalkers();
		for (int i = 0; i < refWalkers.size(); i++) {
			refWalkers.get(i).move();
			assertEquals(currentTestWalkers.get(i).getName(), refWalkers.get(i).getName());
			assertEquals(currentTestWalkers.get(i).getSpeed(), refWalkers.get(i).getSpeed());
			assertEquals(currentTestWalkers.get(i).getPosition(), refWalkers.get(i).getPosition());
		}

	}

	@Test
	public void testGetWinner() {
		// No winner yet
		RaceManager testRaceManager = new RaceManager(cloneWalkers());
		assertTrue(testRaceManager.getWinner() == null);
		for (int i = 0; i < 5; i++) {
			testRaceManager.update();
			assertTrue(testRaceManager.getWinner() == null);
		}

		// One winner
		List<Walker> currentTestWalkers = cloneWalkers();
		Walker targetWalker = currentTestWalkers.get(0);
		while (targetWalker.getPosition() < 10000)
			targetWalker.move();
		testRaceManager = new RaceManager(currentTestWalkers);
		assertTrue(testRaceManager.getWinner() == targetWalker);

		// One HomeWalker winner
		currentTestWalkers = cloneWalkers();
		targetWalker = currentTestWalkers.get(4);
		while (targetWalker.getPosition() < 10000)
			targetWalker.move();
		testRaceManager = new RaceManager(currentTestWalkers);
		assertTrue(testRaceManager.getWinner() == targetWalker);

		// Multiple winner without HomeWalker
		currentTestWalkers = cloneWalkers();
		targetWalker = currentTestWalkers.get(0);
		while (targetWalker.getPosition() < 10000)
			targetWalker.move();
		targetWalker = currentTestWalkers.get(1);
		while (targetWalker.getPosition() < 10000)
			targetWalker.move();
		testRaceManager = new RaceManager(currentTestWalkers);
		assertTrue(testRaceManager.getWinner() == currentTestWalkers.get(0));

		// Multiple winner with HomeWalker
		currentTestWalkers = cloneWalkers();
		targetWalker = currentTestWalkers.get(0);
		while (targetWalker.getPosition() < 10000)
			targetWalker.move();
		targetWalker = currentTestWalkers.get(4);
		while (targetWalker.getPosition() < 10000)
			targetWalker.move();
		testRaceManager = new RaceManager(currentTestWalkers);
		assertTrue(testRaceManager.getWinner() == currentTestWalkers.get(4));

	}
	
	private ArrayList<Walker> cloneWalkers() {
		ArrayList<Walker> newList = new ArrayList<>();
		for (Walker w : testWalkers)
			if (w instanceof HomeWalker)
				newList.add(new HomeWalker((HomeWalker)w));
			else
				newList.add(new Walker(w));
		return newList;
	}

}
