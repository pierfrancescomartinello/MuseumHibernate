package com.museum.MuseumHibernate.util;

import java.nio.ByteBuffer;

public class Main {
	public static void main(String[] args) {
		ByteBuffer firstRes = Utilities.encodingPassoword("test");
		String toRet = Utilities.decodingPassword(firstRes);
		
		System.out.println(firstRes.toString() + " "+ toRet);
	}
}
