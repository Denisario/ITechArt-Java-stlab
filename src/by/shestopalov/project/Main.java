package by.shestopalov.project;

import by.shestopalov.project.classes.Car;
import by.shestopalov.project.classes.Order;
import by.shestopalov.project.classes.Part;
import by.shestopalov.project.enums.FUELTYPE;
import by.shestopalov.project.enums.STATE;
import by.shestopalov.project.user.User;

import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Main {
    public static void main(String[] args) {

        try{
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

            System.out.println(Denis.findById(1));
//            System.out.println(Denis);

//            System.out.println(Denis);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
