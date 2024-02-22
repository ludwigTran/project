package util;

import java.security.MessageDigest;

import org.apache.tomcat.util.codec.binary.Base64;


public class Encoder {
	// md5
	// sha-1 => thường được sử dụng
	public static String toSHA1(String str) {
		String suffix = "asjrlkmcoewj@tjle;oxqskjhdjksjf1jurVn";
		String result = null;
		String str1 = str;
		str = str + suffix;
		try {
			byte[] dataBytes = str.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			result = Base64.encodeBase64String(md.digest(dataBytes)) + "@"+str1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
