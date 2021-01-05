package com.museum.MuseumHibernate.queries.museumDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.museum.MuseumHibernate.modal.Account;
import com.museum.MuseumHibernate.util.Utilities;

public class AccountQueryHandler {

	//Adds an account to the Database
	public static boolean addAccountQuery(String email, String password) throws ClassNotFoundException {
		try {
			String url = "jdbc:mysql://localhost:3306/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root", "password");
			Statement stmn = conn.createStatement();
			int rs = stmn.executeUpdate(
					"INSERT INTO accountp (email, passwordP) VALUES (\"" + email + "\" , \"" + password + "\");");
			stmn.close();
			return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	//Gets a password from the account's email
	public static String getPasswordQuery(String email){
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root", "password");
			Statement stmn = conn.createStatement();
			ResultSet rs = stmn.executeQuery("SELECT passwordp FROM accountP WHERE email = " + email + ";");
			return rs.getString("passwordp");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return "";
		}
	}

	//Modifies an account's password
	public static boolean modifyPasswordQuery(String email, String oldPassword, String newPassword) {
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root", "password");
			Statement stmn = conn.createStatement();
			ResultSet rs = stmn.executeQuery("SELECT passwordp FROM accountP WHERE email = " + email + ";");// Pick old
																											// password
			if (getPasswordQuery(email).equals(oldPassword)) {
				int i = stmn.executeUpdate(
						"UPDATE accountP SET passwordP = " + newPassword + " WHERE email = " + email + ";");
				return true;
			}
			else
				return false;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	//FIX
	public static ArrayList<Account> searchQuery() {
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root", "password");
			Statement stmn = conn.createStatement();
			ResultSet rs = stmn.executeQuery("SELECT * FROM accountP;");
			ArrayList<Account> acc = new ArrayList<Account>();
			String s = "*";
			while(rs.next())
			acc.add(new Account(rs.getString("email"), Utilities.generateHiddenPassword(rs.getString("password").length()), rs.getBoolean("isLoggedIn")));
			stmn.close();
			return acc;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}

	//Sets isLoggedIn of an account
	public static boolean modifyIsLoggedInStateQuery(String email, boolean value) {
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root", "password");
			Statement stmn = conn.createStatement();
			int i = stmn.executeUpdate("UPDATE accountP SET isLoggedIn= " + value + " WHERE email = \"" + email + "\";");
			stmn.close();
			return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	//Deletes an account from the database
	public static boolean deleteAccountQuery(String email) {
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root", "password");
			Statement stmn = conn.createStatement();
			int i = stmn.executeUpdate("DELETE FROM accountP WHERE email = \"" + email + "\";");
			stmn.close();
			return true;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}

}
