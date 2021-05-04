import game.RacingGame;
import game.RacingGameInput;

public class Application {

	public static void main(String[] args) {
		RacingGameInput racingInput = new RacingGameInput();
		RacingGame game = new RacingGame(racingInput);
		game.start();
	}

}
