package SQL_Database.dao;
import SQL_Database.entity.Skill;
import java.util.List;

public interface SkillInterface {
    public List<Skill> getSkillByID(int user_id);

    public List<Skill> getAllSkills();

    public boolean insertSkill(Skill skill);
}
