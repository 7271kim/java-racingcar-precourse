package model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarGroupTest {
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
	public void createValidation() {
		assertThrows(IllegalArgumentException.class, () -> {
			List<Car> cars = new ArrayList<>();
			cars.add(new Car("김석진차"));
			carGroup = new CarGroup(cars);
		});

		assertThrows(IllegalArgumentException.class, () -> {
			List<Car> cars = new ArrayList<>();
			carGroup = new CarGroup(cars);
		});
	}

}
