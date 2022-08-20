package SQL_Database.userDaoImpl;
import AbstractDao.abstractDao;
import dao.NationalityInterface;
import entity.Nationality;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NationalityDaoImpl extends abstractDao implements NationalityInterface {
    private Nationality getNationality(ResultSet res) throws SQLException {
        int nationalityId = res.getInt("id");
        String nationalityName = res.getString("nationality_name");
        return new Nationality(nationalityId,nationalityName);
    }

    public List<Nationality> getAllNationalities(){
        List<Nationality> list = new ArrayList<>();
        try (Connection a = connect()) {
            Statement st = a.createStatement();
            st.execute("select * from nationality");
            ResultSet result = st.getResultSet();
            while (result.next()) {
                Nationality u = getNationality(result);
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
