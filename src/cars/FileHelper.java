package cars;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    public static final String CARS_FILENAME = "cars.txt";
    public static void saveCarsToFile(CarRepository carRepository) {
        BufferedWriter writer = null;

        try {
            File file = new File(CARS_FILENAME);
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(carRepository.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Car> readCarsFromFile() {
        List<Car> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(CARS_FILENAME));
            String line = br.readLine();

            while (line != null) {
                Car car = createCarFromLine(line);
                list.add(car);
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("No file found to read cars from");
        }
        return list;
    }
    private static Car createCarFromLine(String line) {
        String[] parts = line.split(",");
        return new Car(parts[0], parts[1],
                Double.parseDouble(parts[2]), Boolean.parseBoolean(parts[3]));
    }

    private static void writeToFile() {
        BufferedWriter writer = null;
        try {
            File file = new File("example.txt");
            writer = new BufferedWriter(new FileWriter(file));
            writer.write("Testing123");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            String line = br.readLine();

            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
