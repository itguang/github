package cn.itcast.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Test1 {

	/**
	 * @param args
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "%e4%bd%a0%e5%a5%bd";
		s = URLDecoder.decode(s, "UTF-8");
		System.out.println(s);
		
		s = "ÄãºÃ";
		System.out.println(URLEncoder.encode(s, "UTF-8"));
	}

}
