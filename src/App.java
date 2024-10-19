
import business.UserController;
import core.Helper;
import entity.Users;
import view.DashboardUI;
import view.LoginUI;


public class App {
    public static void main(String[] args) {

        Helper.setTheme();
//        LoginUI loginUI = new LoginUI();
        UserController userController = new UserController();
        Users user = userController.findByLogin("example@mail.com","password123");
        DashboardUI dashboardUI = new DashboardUI(user);
    }
}
