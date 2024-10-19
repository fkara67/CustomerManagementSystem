package view;

import business.UserController;
import core.Helper;
import entity.Users;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {
    private JPanel container;
    private JPanel pnl_top;
    private JLabel lbl_title;
    private JPanel pnl_bottom;
    private JTextField fld_mail;
    private JButton btn_login;
    private JLabel lbl_mail;
    private JLabel lbl_password;
    private JPasswordField fld_password;
    private UserController userController;

    public LoginUI() {

        this.userController = new UserController();
        this.add(container);
        this.setTitle("Customer Management System");
        this.setSize(600,500);


        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - this.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - this.getSize().height) / 2;

        this.setLocation(x,y);
        this.setVisible(true);

        this.btn_login.addActionListener(e -> {
            JTextField[] checklist = {this.fld_mail,this.fld_password};
            if (!Helper.isEmailValid(this.fld_mail.getText())) {
                Helper.showMsg("Please enter valid mail address!");
                return;
            }else if (Helper.isFieldListEmpty(checklist)) {
                Helper.showMsg("fill");
            } else {
                Users user = this.userController.findByLogin(this.fld_mail.getText(), this.fld_password.getText());
                if (user == null) {
                    Helper.showMsg("User couldn't be found according to info you entered!!!");
                }else {
                    this.dispose();
                    DashboardUI dashboardUI = new DashboardUI(user);
                }
            }
        });
    }
}
