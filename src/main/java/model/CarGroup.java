package model;

import java.util.List;

public class CarGroup {
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;
	private static final int STANDARD_MOVE_NUMBER = 4;

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
	}

	private void checkValidation(List<Car> cars) {
		checkNull(cars);
		checkSize(cars);
	}

	private void checkNull(List<Car> cars) {
		if (null == cars || cars.size() == 0) {
			throw new IllegalArgumentException("빈 배열이 들어왔습니다. 생성자를 확인하세요");
		}
	}

	private void checkSize(List<Car> cars) {
		if (cars.size() < 2) {
			throw new IllegalArgumentException("최소 2개 이상의 배열이 들어와야 합니다. 생성자를 확인하세요");
		}
	}

	private void moveWithValue(int[] moveValues, int index) {
		int number = moveValues[index];
		if (isMovePossible(number)) {
			cars.get(index).move();
		}
	}

	private boolean isMovePossible(int number) {
		return number >= STANDARD_MOVE_NUMBER;
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
		return (int)((Math.random() * (MAX_NUMBER - MIN_NUMBER + 1)) + MIN_NUMBER);
	}

	protected void moveAll(int[] moveValues) {
		for (int index = 0; index < moveValues.length; index++) {
			moveWithValue(moveValues, index);
		}
	}

}
