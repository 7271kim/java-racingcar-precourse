package model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameCountTest {

	@Test
	@DisplayName("공백 여부 테스트")
	public void checkNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new GameCount("");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new GameCount(null);
		});
	}

	@Test
	@DisplayName("숫자 입력 여부 테스트")
	public void checkNumber() {
		assertThrows(IllegalArgumentException.class, () -> {
			new GameCount("abc");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			new GameCount("a2c");
		});
	}

	@Test
	@DisplayName("0만 입력 여부 테스트")
	public void checkZero() {
		assertThrows(IllegalArgumentException.class, () -> {
			new GameCount("00");
		});
	}
}
