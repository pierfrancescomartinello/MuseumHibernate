package com.museum.MuseumHibernate.queries.museumSales;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Types;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import com.museum.MuseumHibernate.modal.Visitor;
import com.museum.MuseumHibernate.util.Utilities;

public class TicketQueryHandler {
	
	//Adding a ticket to the database
	public static boolean addTicketQuery(String ticketType, LocalDate visitDate, boolean isUsable, BigDecimal ticketPrice, int visitor){
		try {
			int ticketId = Utilities.generateId();
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			int i = stmn.executeUpdate("INSERT INTO ticket (tickedId, ticketType, visitDate, purchaseDate, isUsable, visitor, ticketPrice)" +
									   "VALUES ("+ticketId+" , \""+ticketType+"\" , \'"+ Date.valueOf(visitDate) +"\', \'"+ Date.valueOf(LocalDate.now()) +"\' , \""+(isUsable== true ? 1:0)+"\" , "+visitor+" , "+ticketPrice+");");
			stmn.close();
			return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	//Showing the tickets of a visitor
	public static boolean showTicketsQuery(int visitorId){
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			ResultSet rs = stmn.executeQuery("SELECT * FROM ticket WHERE visitor = "+visitorId);
			while(rs.next()) {
				String ticketId = rs.getString("ticketId");
				String ticketType = rs.getString("ticketType");
				String visitDate = rs.getString("visitDate");
				String purchaseDate = rs.getString("dateOfSignUp");
				String isUsable = rs.getString("isUsable");
				String ticketPrice = rs.getString("ticketPrice");
				System.out.println(ticketId+" - "+ticketType+" - "+visitDate+" - "+purchaseDate+" - "+isUsable+" - "+ticketPrice);
			}
			stmn.close();
			return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
	//Starting a visit
	public static boolean startVisitQuery(int ticketId, int visitorId){
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root","password");
			Statement stmn = conn.createStatement();
			int i = stmn.executeUpdate("UPDATE ticket SET isUsable = \""+false + "\";");
			stmn.close();
			return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
			return false;
		}
	}
	
}
