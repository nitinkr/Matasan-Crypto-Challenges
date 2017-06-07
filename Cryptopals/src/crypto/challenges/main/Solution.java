package crypto.challenges.main;

import crypto.challenges.set1.ConversionUtils;
import java.util.*;
import crypto.challenges.set1.BitwiseUtils;


public class Solution {
	public static void main(String[] args) {
		//Set1_C1();
		//Set1_C2();
		Set1_C3();
	}
	
	public static void Set1_C1() {
		String hex = "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d";
		String b64 = ConversionUtils.hexToBase64(hex);
		System.out.println(b64);
		
		//String res = "SSdtIGtpbGxpbmcgeW91ciBicmFpbiBsaWtlIGEgcG9pc29ub3VzIG11c2hyb29t";
		//System.out.println(b64.equals(res));
	}
	
	public static void Set1_C2() {
		String x = "1c0111001f010100061a024b53535009181c";
		String y = "686974207468652062756c6c277320657965";
		
		byte[] a = ConversionUtils.hexToBytes(x);
		byte[] b = ConversionUtils.hexToBytes(y);
		
		String xJy = ConversionUtils.bytesToHex(BitwiseUtils.xor(a, b));
		System.out.println(xJy);
		
		//String ans = "746865206b696420646f6e277420706c6179";
		//System.out.println(xJy.equals(ans));
		
	}
	
	public static void Set1_C3() {
		String cfr = "1b37373331363f78151b7f2b783431333d78397828372d363c78373e783a393b3736";
		
		byte[] a = ConversionUtils.hexToBytes(cfr);
		
		for(byte key = 'A'; key <= 'Z'; key++) {
			byte[] b = BitwiseUtils.xor(a, key);
			System.out.println(new String(b));
		}		
	}
}
