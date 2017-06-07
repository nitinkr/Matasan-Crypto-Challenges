package crypto.challenges.test;

import crypto.challenges.set1.ConversionUtils;
import java.util.*;

public class Test {
	
	private static String text = "Man is distinguished, not only by his reason, but by this singular passion from other animals, which is a lust of the mind, that by a perseverance of delight in the continued and indefatigable generation of knowledge, exceeds the short vehemence of any carnal pleasure.";
	private static String b64 = "TWFuIGlzIGRpc3Rpbmd1aXNoZWQsIG5vdCBvbmx5IGJ5IGhpcyByZWFzb24sIGJ1dCBieSB0aGlzIHNpbmd1bGFyIHBhc3Npb24gZnJvbSBvdGhlciBhbmltYWxzLCB3aGljaCBpcyBhIGx1c3Qgb2YgdGhlIG1pbmQsIHRoYXQgYnkgYSBwZXJzZXZlcmFuY2Ugb2YgZGVsaWdodCBpbiB0aGUgY29udGludWVkIGFuZCBpbmRlZmF0aWdhYmxlIGdlbmVyYXRpb24gb2Yga25vd2xlZGdlLCBleGNlZWRzIHRoZSBzaG9ydCB2ZWhlbWVuY2Ugb2YgYW55IGNhcm5hbCBwbGVhc3VyZS4=";
	private static Map<String, String> testData;
	static
    {
		testData = new HashMap<String, String>();
		testData.put("M", "TQ==");
		testData.put("Ma", "TWE=");
		
		testData.put("any carnal pleasure.", "YW55IGNhcm5hbCBwbGVhc3VyZS4=");
		testData.put("any carnal pleasure", "YW55IGNhcm5hbCBwbGVhc3VyZQ==");
		testData.put("any carnal pleasur", "YW55IGNhcm5hbCBwbGVhc3Vy");
		testData.put("any carnal pleasu", "YW55IGNhcm5hbCBwbGVhc3U=");
		testData.put("any carnal pleas", "YW55IGNhcm5hbCBwbGVhcw==");
		
		testData.put("pleasure.", "cGxlYXN1cmUu");
		testData.put(text, b64);
		
    }
	
	public static void main(String[] args) {
		//testB64();
		System.out.println(Integer.parseInt("f0", 16));
		testHex2Byte();
		testBytesToHex();
	}
	
	public static void testB64() {
		for(Map.Entry<String, String> kvp : testData.entrySet()) {
			System.out.println(test(kvp.getKey(), kvp.getValue()));
		}
	}
	
	public static void testBytesToHex() {
		String hex = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
		String ans = ConversionUtils.bytesToHex(ConversionUtils.hexToBytes(hex));
		
		System.out.println(hex+" "+ans);
		System.out.println(hex.equals(ans));
	}
	
	public static void testHex2Byte() {
		String hex = "f0";
		byte b = 15;
		byte[] ans = ConversionUtils.hexToBytes(hex);
		for(byte y: ans) {
			System.out.println(y & 0xFF);
		}
	}
	
	public static boolean test(String s, String hex) {
		String h = ConversionUtils.toBase64(s.getBytes());
		//System.out.println(h);
		return h.equals(hex);
	}
}
