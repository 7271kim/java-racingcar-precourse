import game.RacingGame;
import io.RacingGameInput;
import io.RacingGameOutput;
import io.impl.RacingGameConsoleInput;
import io.impl.RacingGameConsoleOutput;

public class Application {

	public static void main(String[] args) {
		RacingGameInput racingInput = new RacingGameConsoleInput();
		RacingGameOutput racingOutput = new RacingGameConsoleOutput();
		RacingGame game = new RacingGame(racingInput, racingOutput);
		game.start();
	}

}
