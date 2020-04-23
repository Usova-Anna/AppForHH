package sample.model;
/*
Connecting to DB and editing data
 */

import sample.Configs;
import sample.Const;
import sample.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

class DataBaseHandler extends Configs implements UserModel {
    Connection dbConnetion;

    public Connection getDbConnetion() throws ClassNotFoundException, SQLException {
        //String connectionString = "jdbc:mysql://localhost:3306/appforhh?autoReconnect=true&useSSL=false&serverTimezone=Europe/London"; //Connection String
        String connectionString = "jdbc:mysql://"
                + dbHost + ":"
                + dbPort + "/"
                + dbName + "?autoReconnect=true&useSSL=false&serverTimezone=Europe/Moscow";
//
//
//        String connectionString = "jdbc:mysql://localhost/appforhh?serverTimezone=UTC+3" //Connection String
//                + dbHost + ":"
//                + dbPort + "/"
//                + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnetion = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnetion;
    }

    @Override
    public void signUpUser(User user) {
        //Добавление данных в БД
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + "," + Const.USERS_USERNAME
                + "," + Const.USERS_PASSWORD + "," + Const.USERS_LOCATION + "," + Const.USERS_GENDER + ")" + "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement prSt = getDbConnetion().prepareStatement(insert);
            prSt.setString(1, user.getFirstName());
            prSt.setString(2, user.getLastName());
            prSt.setString(3, user.getUserName());
            prSt.setString(4, user.getPassword());
            prSt.setString(5, user.getLocation());
            prSt.setString(6, user.getGender());
            prSt.executeUpdate(); //закидывает инфу в БД
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean checkUser(String loginText, String loginPassword) {
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        int counter = 0;
        ResultSet result = getUser(user);
        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;
        }
        return counter > 0;
    }


    //Выгрузка данных из БД
    private ResultSet getUser(User user) {
        ResultSet resSet = null;
        //SQL запрос с отбором по логину и паролю
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " + Const.USERS_USERNAME + "=? AND " + Const.USERS_PASSWORD + "=?";
        try {
            PreparedStatement prSt = getDbConnetion().prepareStatement(select);
            prSt.setString(1, user.getUserName());
            prSt.setString(2, user.getPassword());
            resSet = prSt.executeQuery(); //получить данные из БД
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resSet;
    }
}

