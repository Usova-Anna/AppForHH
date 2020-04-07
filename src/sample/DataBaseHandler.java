package sample;
/*
Connecting to DB and editing data
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBaseHandler extends Configs {
    Connection dbConnetion;

    public Connection getDbConnetion() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" //Connection String
                + dbHost + ":"
                + dbPort + "/"
                + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnetion = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnetion;
    }

    public void signUpUser(String firstName, String lastName, String userName, String password, String location, String gender) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_FIRSTNAME + "," + Const.USERS_LASTNAME + "," + Const.USERS_USERNAME
                + "," + Const.USERS_PASSWORD + "," + Const.USERS_LOCATION + "," + Const.USERS_GENDER + ")" + "VALUES(?,?,?,?,?,?)";
        PreparedStatement prSt = null;
        try {
            prSt = getDbConnetion().prepareStatement(insert);
            prSt.setString(1, firstName);
            prSt.setString(2, lastName);
            prSt.setString(3, userName);
            prSt.setString(4, password);
            prSt.setString(5, location);
            prSt.setString(6, gender);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

