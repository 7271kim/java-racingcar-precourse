package model;

public class CarDistance {

	private static final int START_DISTANCE = 0;

	private int distance;

	public CarDistance() {
		this.distance = START_DISTANCE;
	}

	public int add() {
		return ++this.distance;
	}

	public int getDistance() {
		return distance;
	}

}
