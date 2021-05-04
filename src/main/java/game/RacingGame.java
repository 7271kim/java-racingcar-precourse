package game;

import java.util.ArrayList;
import java.util.List;

import io.RacingGameInput;
import io.RacingGameOutput;
import model.Car;
import model.CarGroup;
import model.GameCount;

public class RacingGame {

	private RacingGameInput racingInput;
	private RacingGameOutput racingOutput;

	public RacingGame(RacingGameInput racingInput, RacingGameOutput racingOutput) {
		this.racingInput = racingInput;
		this.racingOutput = racingOutput;
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
		try {
			racingOutput.requireCount();

			return new GameCount(racingInput.getCountText());
		} catch (Exception e) {
			racingOutput.showText(e.getMessage());

			return getGameCountFromInput();
		}
	}

	private CarGroup getCarGroupFromInput() {
		try {

			return getCarList();
		} catch (Exception e) {
			racingOutput.showText(e.getMessage());

			return getCarGroupFromInput();
		}
	}

	private CarGroup getCarList() {
		racingOutput.requireCarNames();
		String[] carNames = racingInput.getCarNames().split(",");
		List<Car> cars = new ArrayList<>();

		for (String name : carNames) {
			cars.add(new Car(name, racingOutput));
		}

		return new CarGroup(cars, racingOutput);
	}

}
