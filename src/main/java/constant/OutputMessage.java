package constant;

public enum OutputMessage {
	NEED_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
	TRY_COUNT("시도할 회수는 몇회인가요?"),
	WINNER_END("가 최종 우승했습니다.");

	private String text;

	private OutputMessage(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
