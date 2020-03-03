package by.shestopalov.project;

import by.shestopalov.project.classes.Car;
import by.shestopalov.project.classes.Order;
import by.shestopalov.project.classes.Part;
import by.shestopalov.project.jdbc.UserController;
import by.shestopalov.project.user.User;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.Timestamp;


public class Main {
    private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        try{
            BasicConfigurator.configure();

            User Denis=new User("Denis", "Shestopalov", "+375292401246");
            UserController manager=new UserController();
            manager.registerUser(Denis.getFirstName(), Denis.getLastName(), Denis.getPhone());
            Car car=manager.takeCar(1);
            manager.writePartsByCar(car.getCarId());
            Part part1=manager.takePart(2);
            System.out.println(part1);
            Order order=new Order(new Timestamp(65755466875436L), new Timestamp(4324245634256L));
            order.addPart(part1);
            manager.createOrder(Denis, order, 2);
            Denis.addOrder(order);
            System.out.println(Denis);
        }
        catch (Exception ex){
            log.error("Exception: "+ex.getMessage());
        }
    }
}
