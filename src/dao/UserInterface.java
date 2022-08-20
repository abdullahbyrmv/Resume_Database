package SQL_Database.dao;
import SQL_Database.entity.User;
import java.sql.SQLException;
import java.util.List;

public interface UserInterface {

    public User getByID(int id);
    public List<User> getAllInfo() throws SQLException;

    public boolean updateUser(User u);

    public boolean removeUser(int id);

    public boolean addUser(User u);
}
