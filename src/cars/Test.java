package cars;

import java.util.List;
import java.util.Scanner;

import static cars.DisplayingUtil.displayCars;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = FileHelperNIO.readCarsFromFile();
        CarRepository carRepository = new CarRepository(cars);
        while (true) {
            displayMenu();
            int userChoice = scanner.nextInt();
            if (userChoice == 0) {
                FileHelperNIO.saveCarsToFile(carRepository);
                System.out.println("Goodbye");
                break;
            }
            switch (userChoice) {
                case 1:
                    addCar(carRepository, scanner);
                    break;
                case 2:
                    displayCars(carRepository.getCars());
                    break;
                case 3:
                    displayCars(carRepository.getAvailableCars());
                    break;
                case 4:
                    displayCars(carRepository.getRentedCars());
                    break;
                case 5:
                    rentACar(carRepository, scanner);
                    break;
                case 6:
                    returnACar(carRepository, scanner);
                    break;
            }
        }
    }

    private static void returnACar(CarRepository carRepository, Scanner scanner) {
        System.out.println("Which car do you want to return?");
        displayCars(carRepository.getRentedCars());
        int choice = scanner.nextInt() - 1;
        while (choice >= carRepository.getRentedCars().size() || choice < 0) {
            System.out.println("Bad car index, enter again");
            choice = scanner.nextInt() - 1;
        }
        Car car = carRepository.getRentedCars().get(choice);
        car.setRented(false);
        System.out.println("You returned:" + car);
    }

    private static void rentACar(CarRepository carRepository, Scanner scanner) {
        if (carRepository.getAvailableCars().size() == 0) {
            System.out.println("Sorry, no cars.");
            return;
        }
        System.out.println("Which car do you want to rent?");
        displayCars(carRepository.getAvailableCars());
        int choice = scanner.nextInt() - 1; // 1-5 (0-4)
        while (choice >= carRepository.getAvailableCars().size() || choice < 0) {
            System.out.println("Bad car index, enter again");
            choice = scanner.nextInt() - 1;
        }
        Car car = carRepository.getAvailableCars().get(choice);
        car.setRented(true);
        System.out.println("You rented:" + car);
    }

    private static void addCar(CarRepository carRepository, Scanner scanner) {
        System.out.println("Enter maker:");
        scanner.nextLine();
        String maker = scanner.nextLine();
        System.out.println("Enter model:");
        String model = scanner.nextLine();
        System.out.println("Enter hp:");
        double hp = scanner.nextDouble();
        Car car = new Car(maker, model, hp, false);
        carRepository.addCar(car);
    }

    private static void displayMenu() {
        System.out.println("Enter an option:");
        System.out.println("1: Add car");
        System.out.println("2: List all cars");
        System.out.println("3: List all available cars");
        System.out.println("4: List all rented cars");
        System.out.println("5: Pick a car to rent");
        System.out.println("6: Return a car");
        System.out.println("0: Exit");
    }

}
