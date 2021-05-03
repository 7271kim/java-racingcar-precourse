package model;

import constant.TextGroup;

public class Car {

	private CarName carName;
	private CarDistance carDistance;

	public Car(String name) {
		this.carName = new CarName(name);
		this.carDistance = new CarDistance();
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
		System.out.println(getStatus());
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
}
