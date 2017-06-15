package crypto.challenges.main;

import crypto.challenges.set1.ConversionUtils;
import crypto.challenges.set1.CryptoUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import crypto.challenges.set1.BitwiseUtils;


public class Solution {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//Set1_C1();
		//Set1_C2();
		Set1_C3();
		Set1_C4();
		//test();
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
		System.out.println(mostProbableSentence(cfr));
	}
	
	public static void test() {
		String cfr = "32042f46431d2c44607934ed180c1028136a5f2b26092e3b2c4e2930585a";
		System.out.println(mostProbableSentence(cfr));
	}
	
	public static void Set1_C4() throws FileNotFoundException, IOException {
		int i = 0;
		double max = 0;
		String dline = "";
		String path = "C:\\Users\\nitkuma\\crypto-ws\\Matasan-Crypto-Challenges\\Cryptopals\\data\\4.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	//System.out.println(line);
		    	String s = mostProbableSentence(line);
		    	double score = CryptoUtils.scoreSentance(s);
		    	//System.out.println(i+" "+s+" "+ score);
				if (score > max) {
					dline = s;
					max = score;
				}
				i++;
		    }
		}
		System.out.println(dline);
	}
	
	public static String mostProbableSentence(String hex) {
		//System.out.println(hex);
		double max = 0;
		String line = "";
		byte[] a = ConversionUtils.hexToBytes(hex);
		
		for(byte key = 'A'; key <= 'Z'; key++) {
			byte[] b = BitwiseUtils.xor(a, key);
			String s = new String(b);
			double score = CryptoUtils.scoreSentance(s);
			if (score > max) {
				line = s;
				max = score;
			}
			//System.out.println(s+" "+ CryptoUtils.scoreSentance(s));
		}
		
		for(byte key = 'a'; key <= 'z'; key++) {
			byte[] b = BitwiseUtils.xor(a, key);
			String s = new String(b);
			double score = CryptoUtils.scoreSentance(s);
			if (score > max) {
				line = s;
				max = score;
			}
			//System.out.println(s+" "+ CryptoUtils.scoreSentance(s));
		}
		
		for(byte key = '0'; key <= '9'; key++) {
			byte[] b = BitwiseUtils.xor(a, key);
			String s = new String(b);
			double score = CryptoUtils.scoreSentance(s);
			if (score > max) {
				line = s;
				max = score;
			}
			//System.out.println(s+" "+ CryptoUtils.scoreSentance(s));
		}

		return line;
	}
}
