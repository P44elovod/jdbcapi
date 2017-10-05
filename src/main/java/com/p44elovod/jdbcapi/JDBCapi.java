package com.p44elovod.jdbcapi;


import java.sql.*;

public class JDBCapi {


    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


    public static void main(String[] args) {
        String url = "";
        String login = "";
        String password = "";
        String query = "";


        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("WTF Class" + e.getMessage());
        }


        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            System.out.println("Соединение установлено");

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(query);
            int columns = result.getMetaData().getColumnCount();

            while (result.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(result.getString(i) + "\t");
                }
                System.out.println();

            }

            result.close();
            statement.close();
            connection.close();


        } catch (SQLException e) {
            System.out.println("Что-то пошло не так..." + e.getMessage());
            e.printStackTrace();


        }


    }
}
