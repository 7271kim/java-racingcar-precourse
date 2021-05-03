package model;

public class CarName {

	private String name;

	public CarName(String name) {
		checkValidation(name);
		this.name = name;
	}

	private void checkValidation(String name) {
		checkNull(name);
		checkSizeFive(name);
	}

	private void checkSizeFive(String name) {
		if (name.length() > 5) {
			throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
		}
	}

	private void checkNull(String name) {
		if (null == name || "".equals(name)) {
			throw new IllegalArgumentException("이름에 공백은 불가능 합니다.");
		}
	}

	public String getName() {
		return name;
	}

}
