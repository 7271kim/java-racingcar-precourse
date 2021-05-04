package io.impl;

import constant.OutputMessage;
import io.RacingGameOutput;

public class RacingGameConsoleOutput implements RacingGameOutput {

	@Override
	public void requireCarNames() {
		System.out.println(OutputMessage.NEED_CAR_NAME.getText());
	}

	@Override
	public void showText(String message) {
		System.out.println(message);
	}

	@Override
	public void requireCount() {
		System.out.println(OutputMessage.TRY_COUNT.getText());
	}

	@Override
	public void showWinnerMessage(String winner) {
		System.out.println(winner + OutputMessage.WINNER_END.getText());
	}

}
