package SQL_Database.userDaoImpl;
import SQL_Database.AbstractDao.abstractDao;
import SQL_Database.dao.SkillInterface;
import SQL_Database.entity.Skill;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends abstractDao implements SkillInterface {
    private Skill getSkill(ResultSet res) throws SQLException {
        int id = res.getInt("id");
        String skillName = res.getString("skill_name");

        return new Skill(id,skillName);
    }

    @Override
    public List<Skill> getSkillByID(int skill_id) {
        List<Skill> list = new ArrayList<>();
        try (Connection a = connect()) {
            PreparedStatement st = a.prepareStatement("select * from skill where id=?");
            st.setInt(1,skill_id);
            st.execute();
            ResultSet result = st.getResultSet();

            while (result.next()) {
                Skill u = getSkill(result);
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public List<Skill> getAllSkills(){
        List<Skill> list = new ArrayList<>();
        try (Connection a = connect()) {
            Statement st = a.createStatement();
            st.execute("select * from skill");
            ResultSet result = st.getResultSet();

            while (result.next()) {
                Skill u = getSkill(result);
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean insertSkill(Skill skill) {
        try(Connection a = connect()){
            PreparedStatement st = a.prepareStatement("insert into skill(skill_name) values (?)", Statement.RETURN_GENERATED_KEYS);
                    st.setString(1,skill.getName());
            st.execute();

            ResultSet keys = st.getGeneratedKeys();
            if(keys.next()){
                skill.setId(keys.getInt(1));
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
