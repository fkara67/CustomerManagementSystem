package business;

import core.Helper;
import dao.UsersDao;
import entity.Users;

public class UserController {

    private final UsersDao usersDao = new UsersDao();

    public Users findByLogin(String mail, String password) {
        if (!Helper.isEmailValid(mail)) return null;
        return this.usersDao.findByLogin(mail,password);
    }
}
