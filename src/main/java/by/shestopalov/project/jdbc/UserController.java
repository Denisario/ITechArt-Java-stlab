package by.shestopalov.project.jdbc;

import by.shestopalov.project.Exceptions.EngineVolumeException;
import by.shestopalov.project.Exceptions.PriceException;
import by.shestopalov.project.classes.Car;
import by.shestopalov.project.classes.Order;
import by.shestopalov.project.classes.Part;
import by.shestopalov.project.user.AbstractUser;
import by.shestopalov.project.user.User;
import by.shestopalov.project.util.ConnectorDB;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class UserController {
    private static final Logger log = Logger.getLogger(UserController.class);
    private Connection connection;
    private User user;


    public UserController() throws SQLException, IllegalAccessException, InstantiationException,
                                    NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        this.connection = ConnectorDB.getConnection();
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public void registerUser(final String firstName, final String lastName, final String phone) throws SQLException {
        PreparedStatement ps = null;
        ps = connection.prepareStatement(SQLHelper.SQL_INSERT_USER);
        ps.setString(1, firstName);
        ps.setString(2, lastName);
        ps.setString(3, phone);
        int row = ps.executeUpdate();
        log.info("User has been registered");

    }

    public Car takeCar(final long id) throws SQLException, EngineVolumeException {
        PreparedStatement ps = null;
        ps = connection.prepareStatement(SQLHelper.SELECT_CAR_BY_ID);
        ps.setString(1, String.valueOf(id));

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Car resultCar = new Car();
            resultCar.setCarId(id);
            resultCar.setModel(rs.getString("model"));
            resultCar.setMark(rs.getString("mark"));
            resultCar.setYear(rs.getInt("creation_year"));
            resultCar.setEngineVolume(rs.getInt("engine_volume"));
            resultCar.setFuelType(rs.getString("fuel_type"));
            resultCar.setCarcass(rs.getString("carcass_type"));
            log.info("Car was taken");
            return resultCar;
            }
        return null;
    }

    public void writePartsByCar(final long id) throws SQLException {
        PreparedStatement ps1 = null;
        ps1 = connection.prepareStatement(SQLHelper.SELECT_PART_BY_CAR);
        ps1.setString(1, String.valueOf(id));
        ResultSet rs = ps1.executeQuery();

        while(rs.next()){
            System.out.print("id = "+ rs.getString("part_id"));
            System.out.print(" color = "+ rs.getString("color"));
            System.out.print(" category = "+ rs.getString("category"));
            System.out.print(" detail = "+ rs.getString("detail"));
            System.out.print(" price = "+ rs.getString("price"));
        }
        log.info("User showed the list of parts by him car");
    }

    public Part takePart(final long id) throws SQLException, PriceException {
        PreparedStatement ps1 = null;
        ps1 = connection.prepareStatement(SQLHelper.SELECT_PART_BY_ID);
        ps1.setString(1, String.valueOf(id));
        ResultSet rs = ps1.executeQuery();
        while (rs.next()) {
           Part resultPart = new Part();
            resultPart.setPartId(id);
            resultPart.setCarId(rs.getLong("car_id"));
            resultPart.setColor(rs.getString("color"));
            resultPart.setCategory(rs.getString("category"));
            resultPart.setDetail(rs.getString("detail"));
            resultPart.setPrice(rs.getInt("price"));
            log.info("User tanken the part");
           return resultPart;

        }
        return null;
    }

    public void createOrder(AbstractUser user, Order order, long total) throws SQLException {
        PreparedStatement ps1 = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        ps1 = connection.prepareStatement(SQLHelper.INSERT_INFO_ORDER);
        ps1.setString(1, String.valueOf(user.getId()));
        ps1.setString(2, String.valueOf(order.getState()));
        ps1.setString(3, formatter.format(order.getCreationDate()));
        ps1.setString(4, formatter.format(order.getComplectionDate()));
        ps1.setString(5, formatter.format(order.getPossibleComplectionDate()));
        int row=ps1.executeUpdate();
        ps1=connection.prepareStatement(SQLHelper.TAKE_ORDER_ID);
        ResultSet rs=ps1.executeQuery();
        rs.next();
        ps1=connection.prepareStatement(SQLHelper.INSERT_INFO_ORDERED);
        for (var t:order.getParts()) {
            ps1.setString(1, rs.getString("order_id"));
            ps1.setString(2, String.valueOf(t.getPartId()));
            ps1.setString(3, String.valueOf(total));
            int tmp=ps1.executeUpdate();

        }
        log.info("User created the order");
    }
}
