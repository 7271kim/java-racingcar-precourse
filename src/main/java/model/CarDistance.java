package model;

public class CarDistance {

	private int distance;

	public CarDistance() {
		this.distance = 0;
	}

	public int add() {
		return ++this.distance;
	}

	public int getDistance() {
		return distance;
	}

}
