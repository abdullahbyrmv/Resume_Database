package Main;


import userDaoImpl.CountryDaoImpl;

public class Context {
    public static CountryDaoImpl instanceCountryDao() {
        return new CountryDaoImpl();
    }

    public static userDaoImpl.EmploymentHistoryDaoImpl instanceEmploymentHistoryDao() {
        return new userDaoImpl.EmploymentHistoryDaoImpl();
    }

    public static userDaoImpl.SkillDaoImpl instanceSkillDao() {
        return new userDaoImpl.SkillDaoImpl();
    }

    public static userDaoImpl.UserDaoImpl instanceUserDao() {
        return new userDaoImpl.UserDaoImpl();
    }

    public static userDaoImpl.UserSkillDaoImpl instanceUserSkillDao() {
        return new userDaoImpl.UserSkillDaoImpl();
    }

    public static userDaoImpl.NationalityDaoImpl instanceNationalityDao() {
        return new userDaoImpl.NationalityDaoImpl();
    }
}
