package game;

import java.util.ArrayList;
import java.util.List;

import model.Car;
import model.CarGroup;

public class RacingGame {

	private RacingGameInput racingInput;

	public RacingGame(RacingGameInput racingInput) {
		this.racingInput = racingInput;
	}

	public void start() {
		getCarGroupFromInput();
	}

	private CarGroup getCarGroupFromInput() {
		CarGroup result;
		try {
			result = getCarList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = getCarGroupFromInput();
		}
		return result;
	}

	private CarGroup getCarList() {
		String[] carNames = racingInput.getCarNames().split(",");
		List<Car> cars = new ArrayList<>();
		for (String name : carNames) {
			cars.add(new Car(name));
		}
		return new CarGroup(cars);
	}

}
