package dao;

import models.User;

import java.sql.*;

public class DBmanager {

    private Connection connection;

    public void createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/filtersDb?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public User checkUser(String name, String password) {

        String sql = "select * from filtersDb.users where name = ? and password = ?";
        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String username = resultSet.getString("name");
                String userpassword = resultSet.getString("password");
                user = new User(username, userpassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
