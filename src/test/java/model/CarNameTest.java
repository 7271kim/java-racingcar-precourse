package model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

	@Test
	@DisplayName("자동차 이름 유효성 확인 : 5자 이하만 가능하다.")
	public void checkSizeTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CarName("123456");
		});
	}

	@Test
	@DisplayName("자동차 이름 유효성 확인 : 공백은 불가능 하다.")
	public void checkNullTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CarName("");
		});

		assertThrows(IllegalArgumentException.class, () -> {
			new CarName(null);
		});
	}
}
