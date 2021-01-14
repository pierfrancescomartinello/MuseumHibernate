package com.museum.MuseumHibernate.queries.museumNavigation;


import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;

import com.museum.MuseumHibernate.model.Artwork;


public class ArtworkQueryHandler {

	public static Artwork showImage(int artworkId) throws IOException {
		try {
			String url = "jdbc:mysql://localhost/museum?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Connection conn = DriverManager.getConnection(url, "root", "password");
			Statement stmn = conn.createStatement();
			ResultSet rs = stmn.executeQuery("SELECT * FROM artwork where artworkId = " + artworkId +";");
				Artwork artwork = new Artwork(rs.getInt("artworkId") , rs.getString("name"), rs.getString("author"), rs.getDate("submissionDate"), rs.getString("simpledescription"), rs.getString("completedescription") , rs.getInt("areaID") ,BToBI(rs.getBlob("immagine")), BToBI(rs.getBlob("miniatura")));
			stmn.close();
			return artwork;
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			return null;
		}
	}
	
	//from BufferedImage To InputStream
	public static InputStream BIToIS(BufferedImage image) throws IOException {
		ByteArrayOutputStream bas = new ByteArrayOutputStream();
		ImageIO.write(image,"png", bas);
		byte[] bytes = bas.toByteArray();
		InputStream is = new ByteArrayInputStream(bytes);
		return is;
	}
	
	//from Blob To BufferedImage
	public static BufferedImage BToBI(Blob image) throws SQLException, IOException {
		InputStream in = image.getBinaryStream();  
		BufferedImage toReturn = ImageIO.read(in);
		return toReturn;
	}
}
 