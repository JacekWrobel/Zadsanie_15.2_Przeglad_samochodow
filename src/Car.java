import java.util.Objects;

public class Car {
    private String type;
    private String makeOfCar;
    private String model;
    private int year;
    private double mileage;
    private String vin;

    public Car(String type, String makeOfCar, String model, int year, double mileage, String vin) {
        this.type = type;
        this.makeOfCar = makeOfCar;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
        this.vin = vin;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMakeOfCar() {
        return makeOfCar;
    }

    public void setMakeOfCar(String makeOfCar) {
        this.makeOfCar = makeOfCar;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year &&
                Double.compare(car.mileage, mileage) == 0 &&
                Objects.equals(type, car.type) &&
                Objects.equals(makeOfCar, car.makeOfCar) &&
                Objects.equals(model, car.model) &&
                Objects.equals(vin, car.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, makeOfCar, model, year, mileage, vin);
    }

    @Override
    public String toString() {
        return type + " " + makeOfCar + " " + model + " " + year +
                " " + mileage + " " + vin;
    }
    public String toCsv() {
        return type + ";" + makeOfCar + ";" + model + ";" + year +
                ";" + mileage + ";" + vin;
    }

}
