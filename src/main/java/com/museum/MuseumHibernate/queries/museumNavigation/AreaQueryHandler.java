package com.museum.MuseumHibernate.queries.museumNavigation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.museum.MuseumHibernate.util.Utilities;

public class AreaQueryHandler {
	public boolean addAreaQuery(String areaName, String areaStyle, int curatorId) {
		try {
			boolean isAccessible = true;
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			int i = stmn.executeUpdate("INSERT INTO areac ()" +
									   "VALUES (\""+areaName+"\" , \""+areaStyle+"\" , "+curatorId+" "+(isAccessible== true ? 1:0)+";");
			stmn.close();
			return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	public boolean modifyAccessibilityQuery(String areaName, boolean isAccessible) {
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			int i = stmn.executeUpdate("UPDATE areac SET isAccessible = " + true + " WHERE areaName = \"" + areaName +"\";");
			stmn.close();
			return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	public boolean modifyCuratorQuery(String areaName, int newCuratorId) {
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			int i = stmn.executeUpdate("UPDATE areac SET areaName = \"" + areaName +"\" WHERE curatorId = "+newCuratorId + " ;");
			return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}	
	}
}
