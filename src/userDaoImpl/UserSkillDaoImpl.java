package SQL_Database.userDaoImpl;
import SQL_Database.AbstractDao.abstractDao;
import SQL_Database.dao.UserSkillInterface;
import SQL_Database.entity.Skill;
import SQL_Database.entity.User;
import SQL_Database.entity.UserSkill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends abstractDao implements UserSkillInterface {
    private UserSkill getUserSkill(ResultSet res) throws SQLException {
        int userSkillId = res.getInt("userSkillId");
        int userId = res.getInt("id");
        int skillId = res.getInt("skill_id");
        String skillName = res.getString("skill_name");
        int power = res.getInt("power");

        return new UserSkill(userSkillId,new User(userId),new Skill(skillId,skillName),power);
    }

    public List<UserSkill> getAllSkillByUserId(int userId) {
        List<UserSkill> list = new ArrayList<>();
        try (Connection a = connect()) {
            PreparedStatement st = a.prepareStatement("select " +
                    "us.id as userSkillId, " +
                    " u.*, " +
                    " us.skill_id," +
                    " s.skill_name, " +
                    " us.power " +
                    " FROM" +
                    " user_skill us " +
                    " LEFT JOIN user u on us.user_id = u.id " +
                    " left join skill s on us.skill_id = s.id " +
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

    @Override
    public boolean removeUserSkill(int userId) {
        try(Connection a = connect()){
            PreparedStatement st = a.prepareStatement("delete from user_skill where id = ?");
            st.setInt(1,userId);
            return st.execute();
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insertUserSkill(UserSkill u) {
        try(Connection a = connect()){
            PreparedStatement st = a.prepareStatement("insert into user_skill (skill_id,user_id,power) values (?,?,?)");
            st.setInt(1,u.getSkill().getId());
            st.setInt(2,u.getUser().getId());
            st.setInt(3,u.getPower());
            st.execute();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateUserSkill(UserSkill u) {
        try(Connection a = connect()){
            PreparedStatement st = a.prepareStatement("update user_skill set skill_id = ? , user_id = ? , power = ? where id = ?");
            st.setInt(1,u.getSkill().getId());
            st.setInt(2,u.getUser().getId());
            st.setInt(3,u.getPower());
            st.setInt(4,u.getId());
            st.execute();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
