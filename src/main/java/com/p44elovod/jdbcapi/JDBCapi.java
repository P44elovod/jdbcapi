package com.p44elovod.jdbcapi;


import java.sql.*;

public class JDBCapi {


    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/web_project_db";
    static String login = "root";
    static String password = "28101986";
    static String query = "select * from employees";



    private static Connection getDbConnection() {
        Connection сonnection = null;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC драйвер заболел....  "+e.getMessage());
        }
        try {
            сonnection = DriverManager.getConnection(url, login,password);
            System.out.println("Соединение установлено");
            return сonnection;
        } catch (SQLException e) {
            System.out.println("Что-то пошло не так с соединением.... "+e.getMessage());
        }
        return сonnection;
    }

    private static void createDbTableOrDeleteData() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = query;

        try {
            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();


            statement.execute(createTableSQL);
            System.out.println("Действие успешно выполнено");
        } catch (SQLException e) {
            System.out.println("Что-то пошло не так...."+e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }
    private static void insertIntoDbTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String insertData = query;

        try {
            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();


            statement.executeUpdate(insertData);
            System.out.println("Данные успешно добавлены");
        } catch (SQLException e) {
            System.out.println("Что-то пошло не так...."+e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    private static void displayDataFromDbTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;

        String insertData = query;

        try {
            dbConnection = getDbConnection();
            statement = dbConnection.createStatement();


            ResultSet result = statement.executeQuery(query);
            int columns = result.getMetaData().getColumnCount();

            while (result.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(result.getString(i) + "\t");
                }
                System.out.println();

            }
        } catch (SQLException e) {
            System.out.println("Что-то пошло не так...."+e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }



    public static void main(String[] args) throws SQLException {
String key = query
        .toLowerCase()
        .trim()
        .split(" ")[0];

        if (key.equals("create")|| key.equals("delete")){
            createDbTableOrDeleteData();
        }else if (key.equals("insert")){
            insertIntoDbTable();
        }else if (key.equals("select")){
            displayDataFromDbTable();
        }




}






    }

