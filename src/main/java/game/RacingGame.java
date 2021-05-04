package game;

import java.util.ArrayList;
import java.util.List;

import model.Car;
import model.CarGroup;
import model.GameCount;

public class RacingGame {

	private RacingGameInput racingInput;

	public RacingGame(RacingGameInput racingInput) {
		this.racingInput = racingInput;
	}

	public void start() {
		CarGroup group = getCarGroupFromInput();
		GameCount count = getGameCountFromInput();
		for (int index = 0; index < count.getCount(); index++) {
			group.playOne();
		}
		group.showWinner();
	}

	private GameCount getGameCountFromInput() {
		GameCount count;
		try {
			count = new GameCount(racingInput.getGameCount());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			count = getGameCountFromInput();
		}
		return count;
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
