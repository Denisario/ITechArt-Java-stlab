package by.shestopalov.project.user;

import by.shestopalov.project.Exceptions.FindException;
import by.shestopalov.project.classes.Order;

public interface IUser {
    void createOrder(Order order);
    void removeOrder(int index);
    Order findById(int index) throws FindException;
}
