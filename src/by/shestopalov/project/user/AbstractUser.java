package by.shestopalov.project.user;

import by.shestopalov.project.Exceptions.FindException;
import by.shestopalov.project.classes.Order;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class AbstractUser implements IUser {
    private static final Logger log = Logger.getLogger(AbstractUser.class);
    public static int totalId;
    protected long id;
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected ArrayList<Order> orders;


    public AbstractUser(String firstName, String lastName, String phone) {
        log.info("Created user");
        this.firstName=firstName;
        this.lastName=lastName;
        this.phone=phone;
        totalId++;
        this.id=totalId;
        orders = new ArrayList<>();
    }

    @Override
    public void createOrder(Order order) {
        log.info("User added the order");
        this.orders.add(order);
    }

    @Override
    public void removeOrder(int index) {
        log.info("User removed the order");
        this.orders.remove(index);
    }

    @Override
    public Order findById(int index) throws FindException {
        log.info("User find the order by id");
        if(index>orders.size()){
            throw new FindException("Wrong index");
        }
        for (var t:orders) {
            if(t.getOrderId()==index) return t;
        }
        return null;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "AbstractUser{" +
                "id="+ AbstractUser.totalId+
                " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", orders=" + orders +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
