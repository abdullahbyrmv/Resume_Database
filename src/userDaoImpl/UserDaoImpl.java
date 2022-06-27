package userDaoImpl;
import java.sql.*;
import AbstractDao.abstractDao;
import entitiy.Country;
import entitiy.User;
import dao.UserInterface;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends abstractDao implements UserInterface {
    private User getUser(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String name = result.getString("name");
        String surname = result.getString("surname");
        String phone = result.getString("phone");
        String email = result.getString("email");
        int nationality_id = result.getInt("nationality_id");
        int birthPlace_id = result.getInt("birthplace_id");
        String nationalityStr = result.getString("nationality");
        String birthPlaceStr = result.getString("birthplace");
        Date birthdate = result.getDate("birthdate");

        Country nationality = new Country(nationality_id,null,nationalityStr);
        Country birthplace = new Country(birthPlace_id,birthPlaceStr,null);

        return new User(id, name, surname, phone, email,birthdate,nationality,birthplace);
    }

    @Override
    public List<User> getAllInfo() {
        List<User> list = new ArrayList<>();
        try (Connection a = connect()) {
            Statement st = a.createStatement();
            st.execute("select " +
                    "   u.*, " +
                    "   n.nationality, " +
                    "   c.name as birthplace " +
                    "   from user u " +
                    "   left join country n on u.nationality_id = n.id "+
                    "   left join country c on u.birthplace_id = c.id ");
            ResultSet result = st.getResultSet();

            while (result.next()) {
                User u = getUser(result);
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection a = connect()) {
            PreparedStatement st = a.prepareStatement("update user set name = ? where id = ?");
            st.setString(1, u.getName());
            st.setInt(2, u.getId());
            return st.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection a = connect()) {
            Statement st = a.createStatement();
            st.execute("delete from user where id = " + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public User getByID(int userId) {
        User res = null;
        try (Connection a = connect()) {
            Statement st = a.createStatement();
            st.execute("select " +
                    "   u.*, " +
                    "   n.nationality, " +
                    "   c.name as birthplace " +
                    "   from user u " +
                    "   left join country n on u.nationality_id = n.id "+
                    "   left join country c on u.birthplace_id = c.id where u.id = " + userId);
            ResultSet result = st.getResultSet();
            while (result.next()) {
                res = getUser(result);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }

    public boolean addUser(User u) {
        try (Connection a = connect()) {
            PreparedStatement st = a.prepareStatement("insert into user(name,surname,phone,email) values(?,?,?,?)");
            st.setString(1, u.getName());
            st.setString(2, u.getSurname());
            st.setString(3, u.getPhone());
            st.setString(4, u.getEmail());
            return st.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
