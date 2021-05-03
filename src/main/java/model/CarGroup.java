package model;

import java.util.List;

import constant.IntegetGroup;
import constant.ValidationMessage;

public class CarGroup {

	private List<Car> cars;

	public CarGroup(List<Car> cars) {
		checkValidation(cars);
		this.cars = cars;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void playOne() {
		int[] numbers = getRandomNumbers();
		moveAll(numbers);
		showCarsStatus();
	}

	private void showCarsStatus() {
		for (Car car : cars) {
			car.showStatus();
		}
		System.out.println();
	}

	private void checkValidation(List<Car> cars) {
		checkNull(cars);
		checkSize(cars);
	}

	private void checkNull(List<Car> cars) {
		if (null == cars || cars.size() == 0) {
			throw new IllegalArgumentException(ValidationMessage.NOT_EMPTY_SIZE.getMessage());
		}
	}

	private void checkSize(List<Car> cars) {
		if (cars.size() < 2) {
			throw new IllegalArgumentException(ValidationMessage.NOT_ARRAY_SIZE.getMessage());
		}
	}

	private void moveWithValue(int[] moveValues, int index) {
		int number = moveValues[index];
		if (isMovePossible(number)) {
			cars.get(index).move();
		}
	}

	private boolean isMovePossible(int number) {
		return number >= IntegetGroup.STANDARD_MOVE_NUMBER.getNumber();
	}

	protected int[] getRandomNumbers() {
		int size = cars.size();
		int[] result = new int[size];
		for (int index = 0; index < size; index++) {
			result[index] = getRandomNumber();
		}
		return result;
	}

	protected int getRandomNumber() {
		int maxNumber = IntegetGroup.MAX_NUMBER.getNumber();
		int minNumber = IntegetGroup.MIN_NUMBER.getNumber();
		return (int)((Math.random() * (maxNumber - minNumber + 1)) + minNumber);
	}

	protected void moveAll(int[] moveValues) {
		for (int index = 0; index < moveValues.length; index++) {
			moveWithValue(moveValues, index);
		}
	}

}
