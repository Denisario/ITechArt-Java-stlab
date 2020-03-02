package by.shestopalov.project.jdbc;

public class SQLHelper {
    public final static String SQL_INSERT_USER = "INSERT INTO  users (first_name, last_name, phone) VALUES (?, ?, ?)";
    public final static String SELECT_CAR_BY_ID = "SELECT * FROM car WHERE car_id=?";
    public final static String SELECT_PART_BY_CAR = "SELECT * FROM parts INNER JOIN category ON category.category_id=parts.category_id WHERE car_id=?";
    public final static String SELECT_PART_BY_ID="SELECT * FROM parts INNER JOIN category ON category.category_id=parts.category_id WHERE part_id=?";
    public final static String INSERT_INFO_ORDER="INSERT INTO orders (user_id, state, creation_date, completion_date, possible_completion_date) VALUES(?,?,?,?,?)";
    public final static String INSERT_INFO_ORDERED="INSERT INTO ordered (order_id, part_id, amount_part) VALUES(?,?,?)";
    public final static String TAKE_ORDER_ID="SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1";
}
