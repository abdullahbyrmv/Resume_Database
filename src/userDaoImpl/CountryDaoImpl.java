package SQL_Database.userDaoImpl;
import SQL_Database.AbstractDao.abstractDao;
import SQL_Database.dao.CountryInterface;
import SQL_Database.entity.Country;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends abstractDao implements CountryInterface {
    private Country getCountry(ResultSet res) throws SQLException {
        int countryId = res.getInt("id");
        String countryName = res.getString("name");
        return new Country(countryId,countryName,null);
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

    public List<Country> getAllCountries(){
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
