package com.vodvlad.testjfx;

import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    public void signUpUser(String FirstName, String LastName, String Username, String password,
                           String email, String PhoneNumber, String Gender){
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USER_FIRST_NAME + "," + Const.USER_LAST_NAME + "," + Const.USER_USERNAME + "," + Const.USER_PASSWORD + "," + Const.USER_EMAIL + "," + Const.USER_PHONE_NUMBER + "," + Const.USER_GENDER + ")" + "VALUES(?,?,?,?,?,?,?)";


        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, FirstName);
            prSt.setString(2, LastName);
            prSt.setString(3, Username);
            prSt.setString(4, password);
            prSt.setString(5, email);
            prSt.setString(6, PhoneNumber);
            prSt.setString(7, Gender);
            prSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
