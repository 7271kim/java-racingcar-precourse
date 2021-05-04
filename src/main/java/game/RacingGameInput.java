package game;

import java.util.Scanner;

public class RacingGameInput {

	private Scanner scanner;

	public RacingGameInput() {
		scanner = new Scanner(System.in);
	}

	public String getCarNames() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		return getText();
	}

	private String getText() {
		return scanner.nextLine();
	}

}
