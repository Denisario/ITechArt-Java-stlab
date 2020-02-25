package by.shestopalov.project.classes;


import by.shestopalov.project.Exceptions.EngineVolumeException;
import by.shestopalov.project.enums.FUELTYPE;
import org.apache.log4j.Logger;

public class Car {
    private static final Logger log = Logger.getLogger(Car.class);
    public String mark;
    public String model;
    public int year;
    public FUELTYPE fuelType;
    public int engineVolume;

    public Car(String mark, String model, int year, FUELTYPE fuelType, int engineVolume) {
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

    public FUELTYPE getFuelType() {
        return fuelType;
    }

    public void setFuelType(FUELTYPE fuelType) {
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
}
