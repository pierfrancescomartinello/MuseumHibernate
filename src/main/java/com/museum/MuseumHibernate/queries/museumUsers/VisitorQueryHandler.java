package com.museum.MuseumHibernate.queries.museumUsers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class VisitorQueryHandler {

    //Adding a visitor to the database
    @SuppressWarnings("unused")
    public static boolean addVisitorQuery(String name, String surname, LocalDate dateOfBirth, LocalDate dateOfSignUp, boolean isAdult, int visitorId, String email) {
        try {
            String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(url, "root", "password");
            Statement stmn = conn.createStatement();
            ResultSet res = stmn.executeQuery("SELECT email FROM visitor WHERE email = \"" + email + "\"");
            //if(res.getString("email").equals(null)) {
            int i = stmn.executeUpdate("INSERT INTO visitor (fName, surname, dateOfBirth, dateOfsignUp, isAdult, visitorId, email)" +
                "VALUES (\"" + name + "\" , \"" + surname + "\" , \'" + Date.valueOf(dateOfBirth) + "\', \'" + Date.valueOf(dateOfSignUp) + "\' , \"" + (isAdult == true ? 1 : 0) + "\" , \"" + visitorId + "\" , \"" + email + "\");");
            stmn.close();
            return true;
            //}
            //stmn.close();
            //return false;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    //Removing a visitor from the database
    @SuppressWarnings("unused")
    public static boolean deleteVisitorQuery(int visitorId) {
        try {
            String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(url, "root", "password");
            Statement stmn = conn.createStatement();
            int i = stmn.executeUpdate(
                "DELETE FROM visitor WHERE visitorid = \"" + visitorId + "\";");
            stmn.close();
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    //Modifying the isAdult of a visitor
    @SuppressWarnings("unused")
    public static boolean modifyIsAdultQuery(String email) {
        try {
            String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(url, "root", "password");
            Statement stmn = conn.createStatement();
            int i = stmn.executeUpdate("UPDATE visitor SET isAdult = true WHERE email = \"" + email + "\";");
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }

    //Showing all the visitors
    public static boolean showAllVisitors() {
        try {
            String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(url, "root", "password");
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery("SELECT * FROM visitor");
            while (rs.next()) {
                String name = rs.getString("fName");
                String surname = rs.getString("surname");
                String dateOfBirth = rs.getString("dateOfBirth");
                String dateOfSignUp = rs.getString("dateOfSignUp");
                String visitorId = rs.getString("visitorId");
                String email = rs.getString("email");
                boolean id = rs.getBoolean("visitorId");
                System.out.println(visitorId + " - " + name + " - " + surname + " - " + dateOfBirth + " - " + dateOfSignUp + " - " + email + " - " + id);
            }
            stmn.close();
            return true;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        }
    }
}