package com.nbu.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Atanas
 */
public class DatabaseClass {

    public DatabaseClass() {

    }
    /* ------------------------- Class Variables -----------------------------*/
    Connection connection = null;
    Statement statement = null;

    public Connection getMySqlConnection() throws SQLException, ClassNotFoundException {

        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "atanas90";
        String dbname = "betapp";
        Class.forName(driver);
        String url = "jdbc:mysql://localhost:3306/" + dbname;
        connection = DriverManager.getConnection(url, userName, password);
        System.out.println("----------Connection URL: " + connection + "-------");
        return connection;

    }

    /* ------------------------- dbRegister Method -----------------------------*/
    public void dbRegister(String firstname, String lastname, String password, String email) {
        try {
            String query = "INSERT INTO user_info(firstname,lastname,password,email)"
                    + " VALUES('" + firstname + "','" + lastname + "','"+ password + "','" + email + "')";
            connection = getMySqlConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("-------- Query :" + query + " -------------------");
            System.out.println("-------- Registration Done in User Table -------------------");
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
