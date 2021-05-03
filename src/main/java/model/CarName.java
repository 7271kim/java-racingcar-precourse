package model;

import constant.ValidationMessage;

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
			throw new IllegalArgumentException(ValidationMessage.NAME_SIZE.getMessage());
		}
	}

	private void checkNull(String name) {
		if (null == name || "".equals(name)) {
			throw new IllegalArgumentException(ValidationMessage.NOT_NULL.getMessage());
		}
	}

	public String getName() {
		return name;
	}

}
