package by.shestopalov.project.util;

import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConnectorDB
{
    private static final Logger log = Logger.getLogger(ConnectorDB.class);
    public static Connection getConnection() throws SQLException, InstantiationException, IllegalAccessException,
                                                    ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

        Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        ResourceBundle resource = ResourceBundle.getBundle("db", Locale.getDefault());
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        log.info("connection establish");
        return DriverManager.getConnection(url, user, pass);
    }
}
