package cars;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private List<Car> cars;

    public CarRepository(List<Car> cars) {
        this.cars = cars;
    }

    public CarRepository() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getAvailableCars() {
        List<Car> list = new ArrayList<>();
        for (Car car : cars) {
            if (!car.isRented()) {
                list.add(car);
            }
        }
        return list;
    }

    public List<Car> getRentedCars() {
        List<Car> list = new ArrayList<>();
        for (Car car : cars) {
            if (car.isRented()) {
                list.add(car);
            }
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            stringBuilder.append(cars.get(i));
            if (i != cars.size() - 1) {
                stringBuilder.append("\n");
            }
        }
        return stringBuilder.toString();
    }
}
