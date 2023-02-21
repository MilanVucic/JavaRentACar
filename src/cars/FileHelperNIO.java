package cars;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileHelperNIO {
    public static final String CARS_FILENAME = "cars.txt";

    public static void saveCarsToFile(CarRepository carRepository) {
        Path path = Path.of(CARS_FILENAME);
        try {
            Files.writeString(path, carRepository.toString(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Car> readCarsFromFile() {
        List<Car> list = new ArrayList<>();
        Path path = Path.of(CARS_FILENAME);

        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                list.add(createCarFromLine(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    private static Car createCarFromLine(String line) {
        String[] parts = line.split(",");
        return new Car(parts[0], parts[1],
                Double.parseDouble(parts[2]), Boolean.parseBoolean(parts[3]));
    }

}
