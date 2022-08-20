package SQL_Database.AbstractDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class abstractDao {
    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/resume";
        String username = "root";// your database name
        String password = "legendonline1";// your database password
        Connection c = DriverManager.getConnection(url, username, password);
        return c;
    }
}
