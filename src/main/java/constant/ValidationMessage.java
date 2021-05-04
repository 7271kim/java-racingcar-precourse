package constant;

public enum ValidationMessage {
	NAME_SIZE("이름은 5자 이하만 가능합니다."),
	NOT_NULL("공백은 불가능 합니다."),
	NOT_EMPTY_SIZE("빈 배열은 불가능 합니다."),
	NOT_ARRAY_SIZE("최소 2개 이상의 배열이 들어와야 합니다."),
	ONLY_NUMBER("숫자만 가능합니다."),
	NOT_ZERO("0은 입력할 수 없습니다.");

	private String message;

	private ValidationMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
