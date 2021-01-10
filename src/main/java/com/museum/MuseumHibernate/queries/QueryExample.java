package com.museum.MuseumHibernate.queries;

import java.sql.*;
import java.util.ArrayList;

public class QueryExample {

    //Execute a query
    public static ResultSet executeQuery(String sql) {
        try {
            String url = "jdbc:mysql:";
            Connection conn = DriverManager.getConnection(url, "", "");
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery(sql);
            
            return rs;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
    }

    //Takes the result of a query and return it as a proper object
    public static < T > ArrayList < T > QueryDataHandler(ResultSet queryResult) {
        return null;
    }
}