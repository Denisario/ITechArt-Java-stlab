package by.shestopalov.project;

import by.shestopalov.project.classes.Car;
import by.shestopalov.project.classes.Order;
import by.shestopalov.project.classes.Part;
import by.shestopalov.project.enums.FUELTYPE;
import by.shestopalov.project.enums.STATE;
import by.shestopalov.project.user.User;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try{
            BasicConfigurator.configure();
            User Denis=new User("Denis", "12345");
            Calendar calendar=new GregorianCalendar(2001, Calendar.APRIL, 5);
            Order order=new Order(calendar.getTime());
            Car car=new Car("BMW", "E39",2001, FUELTYPE.DIESEL, 3000);
            Part part1=new Part(1, car, "Engine", 500, "red");
            //part1.setPrice(-500);
            Part part2=new Part(2, car, "Engine", 700, "red");
            Denis.createOrder(order);
            order.addPart(part1);
            order.addPart(part2);
            order.changeState(STATE.COMPLETED);
            FileWriter writer = new FileWriter("data.txt", false);
            writer.write(Denis.toString());
            writer.flush();
            log.info("Data writted in file");
            log.info(Denis);
        }
        catch (Exception ex){
            log.error("Exception: "+ex.getMessage());
        }
    }
}
