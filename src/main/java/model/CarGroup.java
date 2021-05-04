package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import constant.ValidationMessage;
import io.RacingGameOutput;

public class CarGroup {

	private static final int ENOUGH_SMALL_NUMBER = -1;
	private static final int MIN_RACEING_CAR_NUMBER = 2;
	private static final int STANDARD_MOVE_NUMBER = 4;
	private static final int MIN_RANDOM_NUMBER = 1;
	private static final int MAX_RANDOM_NUMBER = 9;

	private List<Car> cars;
	private RacingGameOutput output;

	public CarGroup(List<Car> cars, RacingGameOutput output) {
		checkValidation(cars);

		this.cars = cars;
		this.output = output;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void playOne() {
		int[] numbers = getRandomNumbers();

		moveAll(numbers);
		showCarsStatus();
	}

	public void showWinner() {
		List<Car> winners = getWinner();
		List<String> result = getWinnerCarNames(winners);

		output.showWinnerMessage(String.join(",", result));
	}

	private List<String> getWinnerCarNames(List<Car> winners) {
		List<String> result = new ArrayList<>();

		for (Car winner : winners) {
			result.add(winner.getCarName());
		}

		return result;
	}

	private void showCarsStatus() {
		for (Car car : cars) {
			car.showStatus();
		}
		output.showText("");
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
		if (cars.size() < MIN_RACEING_CAR_NUMBER) {
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
		return (int)((Math.random() * (MAX_RANDOM_NUMBER - MIN_RANDOM_NUMBER + 1)) + MIN_RANDOM_NUMBER);
	}

	protected void moveAll(int[] moveValues) {
		for (int index = 0; index < moveValues.length; index++) {
			moveWithValue(moveValues, index);
		}
	}

	protected List<Car> getWinner() {
		Collections.sort(cars);
		List<Car> result = checkDuplicatedWinner();

		return result;
	}

	private List<Car> checkDuplicatedWinner() {
		int min = ENOUGH_SMALL_NUMBER;
		List<Car> result = new ArrayList<>();

		for (Car car : cars) {
			min = setWinner(min, result, car);
		}

		return result;
	}

	private int setWinner(int min, List<Car> result, Car car) {
		int distance = car.getCarDistance();

		if (min <= distance) {
			min = distance;
			result.add(car);
		}

		return min;
	}

}
