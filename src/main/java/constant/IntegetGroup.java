package constant;

public enum IntegetGroup {
	STANDARD_MOVE_NUMBER(4),
	MAX_NUMBER(9),
	MIN_NUMBER(1);

	private int number;

	private IntegetGroup(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}
}
