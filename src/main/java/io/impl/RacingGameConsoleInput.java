package io.impl;

import java.util.Scanner;

import io.RacingGameInput;

public class RacingGameConsoleInput implements RacingGameInput {

	private Scanner scanner;

	public RacingGameConsoleInput() {
		scanner = new Scanner(System.in);
	}

	private String getText() {
		return scanner.nextLine();
	}

	@Override
	public String getCarNames() {
		return getText();
	}

	@Override
	public String getCountText() {
		return getText();
	}

}
