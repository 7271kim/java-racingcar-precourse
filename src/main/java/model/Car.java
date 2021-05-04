package model;

import io.RacingGameOutput;

public class Car implements Comparable<Car> {

	private static final String INTER_TEXT = ":";
	private static final String MOVING_TEXT = "-";

	private CarName carName;
	private CarDistance carDistance;
	private RacingGameOutput output;

	public Car(String name, RacingGameOutput output) {
		this.carName = new CarName(name);
		this.carDistance = new CarDistance();
		this.output = output;
	}

	protected String getStatus() {
		StringBuffer tempBuffer = new StringBuffer();
		appendCarName(tempBuffer);
		appendCarMoving(tempBuffer);

		return tempBuffer.toString();
	}

	private StringBuffer appendCarName(StringBuffer tempBuffer) {
		return tempBuffer.append(carName.getName()).append(INTER_TEXT);
	}

	private void appendCarMoving(StringBuffer tempBuffer) {
		int distance = carDistance.getDistance();

		for (int index = 0; index < distance; index++) {
			tempBuffer.append(MOVING_TEXT);
		}
	}

	public void showStatus() {
		output.showText(getStatus());
	}

	public int move() {
		return carDistance.add();
	}

	public String getCarName() {
		return carName.getName();
	}

	public int getCarDistance() {
		return carDistance.getDistance();
	}

	@Override
	public int compareTo(Car compare) {
		return this.getCarDistance() < compare.getCarDistance() ? 1 : -1;
	}
}
