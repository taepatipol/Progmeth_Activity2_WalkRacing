import java.util.ArrayList;
import java.util.List;

import logic.HomeWalker;
import logic.RaceManager;
import logic.Walker;
import util.RandomGenerator;

public class Main {
	public static void main(String[] args) {
		RandomGenerator.setSeed(9999L);
		List<Walker> walkers = new ArrayList<>();

		walkers.add(new Walker("Alice", 220));
		walkers.add(new HomeWalker("Barbara", 250));
		walkers.add(new Walker("Coco", 280));
		walkers.add(new Walker("Dorothy", 300));
		
		// Add racers here
		RaceManager raceManager = new RaceManager(walkers);
		raceManager.run();
	}
}