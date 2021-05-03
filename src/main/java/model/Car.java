package model;

public class Car {

	private static final String INTER_TEXT = ":";
	private static final String SEPARATOR_TEXT = "-";

	private CarName carName;
	private CarDistance carDistance;

	public Car(String name) {
		this.carName = new CarName(name);
		this.carDistance = new CarDistance();
	}

	protected String getStatus() {
		StringBuffer temp = new StringBuffer();
		temp.append(carName.getName()).append(INTER_TEXT);
		int distance = carDistance.getDistance();
		for (int index = 0; index < distance; index++) {
			temp.append(SEPARATOR_TEXT);
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
