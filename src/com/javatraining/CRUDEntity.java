package com.javatraining;

import java.sql.*;
import java.util.*;

public class CRUDEntity {
    /*
    * step1: init libs
    * step2: init object connection, PrepareStatment
    *       add connect for object connection\
    * step3: add more data
    *       go to mysql, create new student table has 2 properties: username, password in schemas quanlysinhvien
    *       declare a string named sql to add more data
    * step4: add sql string in to PrepareStatment
    * step5: execute that sql
    * step6: close connection
    * */
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public void insert() throws SQLException {
        DBConnection dbConnection = new DBConnection();
        connection = dbConnection.connect();

        String username;
        int password;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        username = scanner.nextLine();

        System.out.print("\nEnter your password: ");
        password = scanner.nextInt();

        String sql = "insert into student(username,password) values(?,?)";

        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setInt(2, password);
            int result = statement.executeUpdate();

            if(result!=0){
                System.out.println("Update success!!" + result);
            }else{
                System.out.println("Fail, Please check again!!1");
            }
            statement.close();

        }catch (SQLException e){
            System.err.println("Loi : " + e.getMessage());
        }
        finally {
            if (connection != null){
                connection.close();
            }
        }

    }

    public void displayAll() throws SQLException {
        DBConnection dbConnection = new DBConnection();

        connection = dbConnection.connect();

        String sql = "select * from student";

        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            String username;
            int pass, id;
            System.out.println("|\t#\t|\tusername\t|\tpassword\t");
            while(resultSet.next()){
                id = resultSet.getInt("studentid");
                username = resultSet.getString("username");
                pass = resultSet.getInt("password");
                System.out.printf("|\t%d\t|\t%s\t|\t%d\t",id,username,pass);
            }



        }catch (SQLException e){
            System.err.println("loi: "+ e.getMessage());
        }

        finally {
            statement.close();
            if(connection!=null){
                connection.close();
            }
        }
    }

    public void delete() throws SQLException {
        DBConnection conn = new DBConnection();
       try {
           connection = conn.connect();

           int id;
           Scanner scanner = new Scanner(System.in);

           System.out.print("Enter id of student need remove: ");
           id = scanner.nextInt();
           String sql = "delete from student where studentid = ? ";
           statement = connection.prepareStatement(sql);
           statement.setInt(1, id);
           statement.executeUpdate();
       }catch (SQLException e){
           System.err.println("loi: " + e.getMessage());
       }
        finally {
           statement.close();
           if(connection!=null){
               connection.close();
           }

       }
    }
}
