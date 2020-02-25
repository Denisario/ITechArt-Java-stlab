package by.shestopalov.project.user;

import by.shestopalov.project.Exceptions.FindException;
import by.shestopalov.project.classes.Order;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class AbstractUser implements IUser {
    private static final Logger log = Logger.getLogger(AbstractUser.class);
    public String login;
    public String password;
    public ArrayList<Order> orders;

    public AbstractUser(String login, String password) {
        log.info("Created user");
        this.login = login;
        this.password = password;
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

    @Override
    public String toString() {
        return "AbstractUser{" +
                "orders=" + this.orders +
                '}';
    }
}
