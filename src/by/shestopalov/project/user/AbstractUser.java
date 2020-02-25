package by.shestopalov.project.user;

import by.shestopalov.project.Exceptions.FindException;
import by.shestopalov.project.classes.Order;

import java.util.ArrayList;

public class AbstractUser implements IUser {
    public String login;
    public String password;
    public ArrayList<Order> orders;

    public AbstractUser(String login, String password) {
        this.login = login;
        this.password = password;
        orders = new ArrayList<>();
    }

    @Override
    public void createOrder(Order order) {
        this.orders.add(order);
    }

    @Override
    public void removeOrder(int index) {
        this.orders.remove(index);
    }

    @Override
    public Order findById(int index) throws FindException {
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
