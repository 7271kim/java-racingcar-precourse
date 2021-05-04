package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.RacingGameOutput;
import io.impl.RacingGameConsoleOutput;

public class CarTest {

	private Car car;
	private RacingGameOutput output = new RacingGameConsoleOutput();

	@BeforeEach
	public void setUp() {
		car = new Car("김석진차", output);
	}

	@Test
	@DisplayName("Car 클래스 자신의 move 시 1칸 전진 테스트")
	public void moveTest() {
		assertThat(car.move()).isEqualTo(1);
	}

	@Test
	@DisplayName("Car 클래스 자신의 distance 및 이름 출력 테스트")
	public void showStatusTest() {
		assertThat(car.getStatus()).isEqualTo("김석진차:");
		car.move();
		assertThat(car.getStatus()).isEqualTo("김석진차:-");
		car.move();
		assertThat(car.getStatus()).isEqualTo("김석진차:--");
	}
}
