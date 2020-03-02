package by.shestopalov.project.classes;


import by.shestopalov.project.Exceptions.EngineVolumeException;
import org.apache.log4j.Logger;

public class Car {
    private static final Logger log = Logger.getLogger(Car.class);
    private long carId;
    private String mark;
    private String model;
    private int year;
    private String fuelType;
    private int engineVolume;
    private String carcass;

    public Car(String mark, String model, int year, String fuelType, int engineVolume) {
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.engineVolume = engineVolume;
        log.info("Car has been created");
    }

    public Car() {
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
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

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) throws EngineVolumeException {
        if(engineVolume<0) throw new EngineVolumeException("Wrong engine volume");
        this.engineVolume = engineVolume;
    }

    @Override
    public String toString() {
        return "Car {" +
                "mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", fuelType=" + fuelType +
                ", engineVolume=" + engineVolume +
                '}';
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getCarcass() {
        return carcass;
    }

    public void setCarcass(String carcass) {
        this.carcass = carcass;
    }
}
