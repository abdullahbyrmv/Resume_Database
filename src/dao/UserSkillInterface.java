package dao;


import entity.UserSkill;

import java.util.List;

public interface UserSkillInterface {
    public List<UserSkill> getAllSkillByUserId(int userId);

    public boolean removeUserSkill(int userId);

    public boolean insertUserSkill(UserSkill u);

    public boolean updateUserSkill(UserSkill u);
}
