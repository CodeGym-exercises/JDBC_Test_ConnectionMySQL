package com.javatraining;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {


    public static void main(String[] args) throws SQLException {
//        Class.forName("com.mysql.jdbc.Driver"); if jdk version lesser than 6
        CRUDEntity crudEntity = new CRUDEntity();

        //crudEntity.displayAll();

        crudEntity.delete();

        crudEntity.displayAll();
    }
}
