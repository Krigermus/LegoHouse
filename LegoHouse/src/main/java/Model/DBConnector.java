package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Martin Frederiksen
 */
public class DBConnector {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://157.230.110.164:3306/LegoHouse";
    private static final String USER = "transform";
    private static final String PASSWORD = "transform";
    private Connection connection;
    private static DBConnector instance;
    

    /*public static void setConnection(Connection con) {
        connection = con;
    }*/
    
    public synchronized static DBConnector getInstance() throws ClassNotFoundException, SQLException {
    if (instance == null) instance = new DBConnector();
    else if(instance.getConnection().isClosed()) instance = new DBConnector();
    return instance;
    }
    
    public Connection getConnection(){
        return connection;
    }
    
    private DBConnector() throws ClassNotFoundException, SQLException {
        if (connection == null) {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }
}
