import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    static Connection connection;
    public  Connection getConnection()  {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/youtubeschool", "root", "");

        }catch (Exception ex) {
            System.out.println(ex);}
        return connection;
    }
}
