package logic;

import util.RandomGenerator;

public class HomeWalker extends Walker {

	public HomeWalker(String name, int speed) {
		super(name, speed);
	}
	
	public HomeWalker(HomeWalker other) {
		super(other);
	}

	@Override
	public void move() {
		this.position += this.speed;
		homeBuff();
		homeBuff();
	}

	private void homeBuff() {
		this.position += RandomGenerator.random(0, 200);
	}
}
