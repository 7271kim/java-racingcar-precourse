package model;

import constant.TextGroup;
import io.RacingGameOutput;

public class Car implements Comparable<Car> {

	private CarName carName;
	private CarDistance carDistance;
	private RacingGameOutput output;

	public Car(String name, RacingGameOutput output) {
		this.carName = new CarName(name);
		this.carDistance = new CarDistance();
		this.output = output;
	}

	protected String getStatus() {
		StringBuffer temp = new StringBuffer();
		temp.append(carName.getName()).append(TextGroup.INTER_TEXT.getText());
		int distance = carDistance.getDistance();
		for (int index = 0; index < distance; index++) {
			temp.append(TextGroup.SEPARATOR_TEXT.getText());
		}
		return temp.toString();
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
