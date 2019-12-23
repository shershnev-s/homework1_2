package by.tut.shershnev_s.service.model;

/**
 * Created by user on 28.11.2019.
 */
public class Car {
    private String name;
    private CarModel carModel;
    private int engineCapacity;

    public Car(CarModel carModel, int engineCapacity, String name) {
        this.carModel = carModel;
        this.engineCapacity = engineCapacity;
        this.name = name;
    }

    public CarModel getCarModel() {
        return carModel;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public String getName() {
        return name;
    }
}
