package cars;

public class Car {
    private String maker;
    private String model;
    private double horsePower;
    private boolean isRented;

    public Car(String maker, String model, double horsePower, boolean isRented) {
        this.maker = maker;
        this.model = model;
        this.horsePower = horsePower;
        this.isRented = isRented;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(double horsePower) {
        this.horsePower = horsePower;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    @Override
    public String toString() {
        return maker + "," + model + "," + horsePower + "," + isRented;
    }
}
