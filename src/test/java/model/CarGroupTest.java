package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarGroupTest {
	private static final int ENOUGH_BIG_NUMBER = 10000;
	private CarGroup carGroup;

	@BeforeEach
	public void setUp() {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("김석진차"));
		cars.add(new Car("우리집차"));
		cars.add(new Car("학원차"));
		carGroup = new CarGroup(cars);
	}

	@Test
	@DisplayName("carGroup의 멤버변수 List<Car> 최소 2개 이상이다.")
	public void checkValidation() {
		assertThrows(IllegalArgumentException.class, () -> {
			List<Car> cars = new ArrayList<>();
			cars.add(new Car("김석진차"));
			carGroup = new CarGroup(cars);
		});
	}

	@Test
	@DisplayName("carGroup의 멤버변수 List<Car>은 크기가 0이 될 수 없다")
	public void checkValidationSize() {
		assertThrows(IllegalArgumentException.class, () -> {
			List<Car> cars = new ArrayList<>();
			carGroup = new CarGroup(cars);
		});
	}

	@Test
	@DisplayName("1부터 9까지의 수를 random으로 뽑는지 테스트")
	public void getRandomNumberTest() {
		int[] cache = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		checkOneToNine(cache);
		checkHasAllNumber(cache);
	}

	@Test
	@DisplayName("List<Car> 크기의 1-9까지의 랜덤 수를 담은 메서트  getRandomNumbers 테스트")
	public void getRandomNumbersTest() {
		assertThat(carGroup.getRandomNumbers().length).isEqualTo(3);
	}

	private void checkHasAllNumber(int[] cache) {
		for (int index = 1; index < 9; index++) {
			assertThat(cache[index]).isEqualTo(1);
		}
	}

	private void checkOneToNine(int[] cache) {
		for (int index = 0; index < ENOUGH_BIG_NUMBER; index++) {
			int randomNumber = carGroup.getRandomNumber();
			assertThat(randomNumber).isBetween(1, 9);
			cache[randomNumber] = 1;
		}
	}

}
