package model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarDistanceTest {

	private CarDistance carDistance;

	@BeforeEach
	public void setup() {
		carDistance = new CarDistance();
	}

	@Test
	@DisplayName("자동차 거리 int를 포장한 클래스 CarDistance add시 distance 1증가 테스트")
	public void addTest() {
		assertThat(carDistance.add()).isEqualTo(1);
		assertThat(carDistance.getDistance()).isEqualTo(1);
	}
}
