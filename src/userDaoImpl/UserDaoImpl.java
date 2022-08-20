package SQL_Database.userDaoImpl;
import SQL_Database.AbstractDao.abstractDao;
import SQL_Database.dao.UserInterface;
import SQL_Database.entity.Country;
import SQL_Database.entity.Nationality;
import SQL_Database.entity.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends abstractDao implements UserInterface {
    private User getUser(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String name = result.getString("name");
        String surname = result.getString("surname");
        String phone = result.getString("phone");
        String email = result.getString("email");
        String profileDescription = result.getString("profile_description");
        String address = result.getString("address");
        int nationality_id = result.getInt("nationality_id");
        int birthPlace_id = result.getInt("birthplace_id");
        String nationalityStr = result.getString("nationality_name");
        String birthPlaceStr = result.getString("birthplace");
        Date birthdate = result.getDate("birthdate");
        String header = result.getString("old_company_name");
        Date begin_date = result.getDate("begin_date");
        Date end_date = result.getDate("end_date");
        String Description = result.getString("job_description");

        Nationality nationality = new Nationality(nationality_id,nationalityStr);
        Country birthplace = new Country(birthPlace_id,birthPlaceStr,null);

        return new User(id, name, surname, phone, email, profileDescription, address, birthdate, nationality, birthplace,header,begin_date,end_date,Description);
    }

    @Override
    public List<User> getAllInfo() {
        List<User> list = new ArrayList<>();
        try (Connection a = connect()) {
            Statement st = a.createStatement();
            st.execute("select " +
                    "   u.*, " +
                    "   n.nationality_name, " +
                    "   c.name as birthplace, " +
                    " from user u " +
                    " left join nationality n on u.nationality_id = n.id " +
                    " left join country c on u.birthplace_id = c.id ");
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
            PreparedStatement st = a.prepareStatement("update user set name=?,surname=?,phone=?,email=?,profile_description=?,address=?,birthdate=?,birthplace_id=? , nationality_id = ?, old_company_name = ?, begin_date = ?, end_date = ? , job_description = ? where id = ?");
            st.setString(1,u.getName());
            st.setString(2,u.getSurname());
            st.setString(3,u.getPhone());
            st.setString(4,u.getEmail());
            st.setString(5,u.getProfileDescription());
            st.setString(6,u.getAddress());
            st.setDate(7,u.getBirthDate());
            st.setInt(8,u.getBirthPlace().getId());
            st.setInt(9,u.getNationality().getId());
            st.setString(10,u.getHeader());
            st.setDate(11,u.getBegin_date());
            st.setDate(12,u.getEnd_date());
            st.setString(13,u.getJob_description());
            st.setInt(14,u.getId());
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
                    "   n.nationality_name, " +
                    "   c.name as birthplace " +
                    "   from user u " +
                    "   left join nationality n on u.nationality_id = n.id "+
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
            PreparedStatement st = a.prepareStatement("insert into user(name,surname,phone,email,profile_description,address,birthdate) values(?,?,?,?,?,?,?)");
            st.setString(1, u.getName());
            st.setString(2,u.getSurname());
            st.setString(3,u.getPhone());
            st.setString(4,u.getEmail());
            st.setString(5,u.getProfileDescription());
            st.setString(6,u.getAddress());
            st.setDate(7,u.getBirthDate());
            return st.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
