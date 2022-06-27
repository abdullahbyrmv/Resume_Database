package Main;

import userDaoImpl.SkillDaoImpl;

public class Main {

    public static void main(String[] args) {
        SkillDaoImpl a = new SkillDaoImpl();
        System.out.println(a.getSkillByID(1));
    }
}
