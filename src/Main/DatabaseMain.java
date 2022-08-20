package SQL_Database.Main;

import dao.UserInterface;
import entity.User;

public class DatabaseMain {

    public static void main(String[] args) {
        UserInterface userDao = Context.instanceUserDao();
        User u = userDao.getByID(8);
        System.out.println(u.getEmail());
    }
}
