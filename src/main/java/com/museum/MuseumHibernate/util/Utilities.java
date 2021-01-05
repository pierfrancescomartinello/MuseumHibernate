package com.museum.MuseumHibernate.util;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class Utilities{
	
	public static LocalDate LocalDateCreator(int dd, Month mmm, int yyyy) {
		LocalDate date = LocalDate.of(yyyy, mmm, dd);
		return date;
	}
	
	
	public static String LocalDatePrinter(LocalDate date , String separator){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd " + separator + " MMM " + separator + " yyyy", Locale.ENGLISH);
		System.out.println(formatter.format(date));
		return formatter.format(date);
	}
	
	public static int generateId(){
		Random rd = new Random();
		int id = rd.nextInt();
		return id;
	}
	
	public static String generatePassword(){
		byte[] array = new byte[10];
		new Random().nextBytes(array);
		String generatedPassword = new String(array, Charset.forName("UTF-8"));
		return generatedPassword;
	}
	
	public static String generateHiddenPassword(int length){
		String s = "*";
		return s.repeat(length);
	}
}
