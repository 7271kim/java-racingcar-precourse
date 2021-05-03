package model;

import java.util.List;

public class CarGroup {

	private List<Car> cars;

	public CarGroup(List<Car> cars) {
		checkValidation(cars);
		this.cars = cars;
	}

	private void checkValidation(List<Car> cars) {
		checkNull(cars);
		checkSize(cars);
	}

	private void checkNull(List<Car> cars) {
		if (null == cars || cars.size() == 0) {
			throw new IllegalArgumentException("빈 배열이 들어왔습니다. 생성자를 확인하세요");
		}
	}

	private void checkSize(List<Car> cars) {
		if (cars.size() < 2) {
			throw new IllegalArgumentException("최소 2개 이상의 배열이 들어와야 합니다. 생성자를 확인하세요");
		}
	}

}
