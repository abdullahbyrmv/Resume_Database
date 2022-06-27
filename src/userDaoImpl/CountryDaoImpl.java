package userDaoImpl;
import AbstractDao.abstractDao;
import dao.CountryInterface;
import entitiy.Country;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends abstractDao implements CountryInterface {
    private Country getCountry(ResultSet res) throws SQLException {
        int countryId = res.getInt("id");
        String countryName = res.getString("name");
        String nationalityName = res.getString("nationality");
        return new Country(countryId,countryName,nationalityName);
    }

    @Override
    public List<Country> getCountryById(int country_id) {
        List<Country> list = new ArrayList<>();
        try (Connection a = connect()) {
            PreparedStatement st = a.prepareStatement("select * from country where id=?");
            st.setInt(1,country_id);
            st.execute();
            ResultSet result = st.getResultSet();

            while (result.next()) {
                Country u = getCountry(result);
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Country> getAllCountry(){
        List<Country> list = new ArrayList<>();
        try (Connection a = connect()) {
            Statement st = a.createStatement();
            st.execute("select * from country");
            ResultSet result = st.getResultSet();
            while (result.next()) {
                Country u = getCountry(result);
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
