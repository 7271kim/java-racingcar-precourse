package constant;

public enum TextGroup {
	INTER_TEXT(":"),
	SEPARATOR_TEXT("-");

	private String text;

	private TextGroup(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
