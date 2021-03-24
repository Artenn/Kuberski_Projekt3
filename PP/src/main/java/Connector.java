import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static String URL = "jdbc:mysql://localhost:3306/projekt2?useUnicode=yes&characterEncoding=UTF-8";
    private static String USER = "test";
    private static String PASS= "12345";
    private static Connection connection;



    public static Connection connect(){
        try {
            connection = DriverManager.getConnection(URL,USER,PASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            return connection;
        }

    }
}