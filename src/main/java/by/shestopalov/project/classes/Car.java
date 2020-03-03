package by.shestopalov.project.classes;

import by.shestopalov.project.Exceptions.EngineVolumeException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.log4j.Logger;

@Getter
@Setter
@NoArgsConstructor
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
