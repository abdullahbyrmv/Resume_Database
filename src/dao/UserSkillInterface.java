package dao;
import entitiy.UserSkill;
import java.util.List;

public interface UserSkillInterface {
    public List<UserSkill> getAllSkillByUserId(int userId);
}
