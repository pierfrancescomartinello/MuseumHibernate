package com.museum.MuseumHibernate.queries.museumNavigation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ArtworkQueryHandler {
	
	//Execute a query
		public static ResultSet executeQuery(String sql){
			try {
			String url = "jdbc:mysql:";
			Connection conn = DriverManager.getConnection(url, "","");
			Statement stmn = conn.createStatement();
			ResultSet rs = stmn.executeQuery(sql);
			return rs;
		}catch(SQLException sqle) {
				sqle.printStackTrace();
				return null;
			}
		}
		
		//Takes the result of a query and return it as a proper object
		public static <T> ArrayList<T> QueryDataHandler(ResultSet queryResult){
			return null;
		}
}
