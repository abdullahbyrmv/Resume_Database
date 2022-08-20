package SQL_Database.dao;
import SQL_Database.entity.Country;
import java.util.List;

public interface CountryInterface {
    public List<Country> getCountryById(int id);

    public List<Country> getAllCountries();
}
