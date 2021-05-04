package model;

import java.util.regex.Pattern;

import constant.ValidationMessage;

public class GameCount {
	int count;

	public GameCount(String inputNumber) {
		inputNumber = removeTrim(inputNumber);
		checkValidation(inputNumber);
		count = Integer.parseInt(inputNumber);
	}

	private String removeTrim(String inputNumber) {
		return null != inputNumber ? inputNumber.trim() : "";
	}

	private void checkValidation(String inputNumber) {
		checkNull(inputNumber);
		checkNumber(inputNumber);
		checkZero(inputNumber);
	}

	private void checkZero(String inputNumber) {
		if (inputNumber.replaceAll("0", "").equals("")) {
			throw new IllegalArgumentException(ValidationMessage.NOT_ZERO.getMessage());
		}
	}

	private void checkNumber(String inputNumber) {
		if (!Pattern.matches("^[0-9]+$", inputNumber)) {
			throw new IllegalArgumentException(ValidationMessage.ONLY_NUMBER.getMessage());
		}
	}

	private void checkNull(String inputNumber) {
		if (null == inputNumber || "".equals(inputNumber)) {
			throw new IllegalArgumentException(ValidationMessage.NOT_NULL.getMessage());
		}
	}

	public int getCount() {
		return count;
	}

}
