package com.sisga.core.core.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtils {

	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

	public static String encrypt( String text ) {
		String encryptedText = null;
		byte encrypted[] = null;
		try {
			MessageDigest algorithm = MessageDigest.getInstance( "MD5" );
			encrypted = algorithm.digest( text.getBytes( "UTF-8" ) );
			encryptedText = bytesToHex( encrypted );
		} catch( Exception e ) {
			e.printStackTrace();
		}

		return encryptedText;
	}

	private static String bytesToHex( byte[] bytes ) {
		char[] hexChars = new char[bytes.length * 2];
		for( int j = 0; j < bytes.length; j ++ ) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String( hexChars );
	}

	public static void main( String[] args ) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		System.out.println( encrypt( "TESTE" ) );
	}
}
