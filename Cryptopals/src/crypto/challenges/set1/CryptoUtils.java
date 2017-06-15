package crypto.challenges.set1;

import java.util.List;

public class CryptoUtils {
	public static double scoreSentance(String s) {
		if(s == null || s.length() == 0)
			return 0;
		double ws = (countKey(s, ' ') * 1.0) / s.length();
		double alphaScore = (countAlphabetic(s) * 1.0) / s.length();
		
		if(ws > alphaScore) {
			return 0;
		}
		
		return 0.8 * ws + 0.1 * alphaScore;
	}
	
	private static int countKey(String s, char key) {
		int count = 0;
		for(char c : s.toCharArray()) {
			if (c == key) {
				count++;
			}
		}
		return count;
	}
	
	private static int countAlphabetic(String s) {
		int count = 0;
		for(char c : s.toCharArray()) {
			if (Character.isAlphabetic(c)) {
				count++;
			}
		}
		return count;
	}
}
