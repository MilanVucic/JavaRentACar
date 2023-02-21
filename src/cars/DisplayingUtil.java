package cars;

import java.util.List;

public class DisplayingUtil {

    public static void displayCars(List<Car> cars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            stringBuilder.append((i + 1) + ".").append(cars.get(i));
            if (i != cars.size() - 1) {
                stringBuilder.append("\n");
            }
        }
        System.out.println(stringBuilder);
    }

}
