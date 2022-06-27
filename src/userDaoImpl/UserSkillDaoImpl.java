package userDaoImpl;
import AbstractDao.abstractDao;
import dao.UserSkillInterface;
import entitiy.Skill;
import entitiy.User;
import entitiy.UserSkill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends abstractDao implements UserSkillInterface {
    private UserSkill getUserSkill(ResultSet res) throws SQLException {
        int userId = res.getInt("id");
        int skillId = res.getInt("skill_id");
        String skillName = res.getString("skill_name");
        int power = res.getInt("power");

        return new UserSkill(null,new User(userId),new Skill(skillId,skillName),power);
    }

    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> list = new ArrayList<>();
        try (Connection a = connect()) {
            PreparedStatement st = a.prepareStatement("select" +
                    " u.*, " +
                    " us.skill_id," +
                    " s.name as skill_name, " +
                    " us.power " +
                    " FROM" +
                    " user_skill us " +
                    " LEFT JOIN user u on us.user_id = u.id " +
                    " left join skill as s on us.skill_id = s.id " +
                    " WHERE " + "us.user_id = ?");
            st.setInt(1,userId);
            st.execute();
            ResultSet result = st.getResultSet();

            while (result.next()) {
                UserSkill u = getUserSkill(result);
                list.add(u);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
