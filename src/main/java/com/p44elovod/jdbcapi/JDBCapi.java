package com.p44elovod.jdbcapi;

import java.sql.*;

public class JDBCapi {


    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";




    public static void main(String[] args){
       String url = "";
       String login = "";
       String password = "";
       String query = "";
       try {


        Connection connection = DriverManager.getConnection(login, url,password);
           System.out.println("Соединение установлено");

           Statement statement = null;
           connection.createStatement();
           ResultSet result = statement.executeQuery(query);

           while (result.next()){
               System.out.println("");
               System.out.println("");
               System.out.println("");
               System.out.println("");
           }



       }catch (SQLException e){
           System.out.println("Что-то пошло не так...");
           e.printStackTrace();
       }


    }



}
