package dao;
import entitiy.Skill;
import entitiy.User;

import java.util.List;

public interface SkillInterface {
    public List<Skill> getSkillByID(int user_id);
}
