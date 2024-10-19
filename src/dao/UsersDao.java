package dao;

import core.Database;
import entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsersDao {
    private Connection connection;

    public UsersDao() {
        this.connection = Database.getInstance();
    }

    public Users findByLogin(String mail, String password) {
        Users user = null;
        String query = "SELECT * FROM users WHERE mail = ? AND password = ?";
        try {
            PreparedStatement pr = this.connection.prepareStatement(query);
            pr.setString(1,mail);
            pr.setString(2,password);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                user = this.match(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public ArrayList<Users> findAll() {
        ArrayList<Users> users = new ArrayList<>();

        try {
            ResultSet rs = this.connection.createStatement().executeQuery("SELECT * FROM users");
            while(rs.next()) {
                users.add(this.match(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public Users match(ResultSet rs) throws SQLException {
        Users user = new Users();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        user.setMail(rs.getString("mail"));
        return user;
    }
}
