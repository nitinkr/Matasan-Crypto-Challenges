package crypto.challenges.set1;

public class ConversionUtils {
	
	public static String toBase64(byte[] in) {
		
		StringBuilder hex = new StringBuilder();
		
		int left = 0;
		
		for(int i=0; i < in.length; i++) {
			int index = 0;
			String token = "";
			if (left == 0) {
				index = (in[i] & (0xfc))>>2;
				left = 2;
				token += getHexToken(index);		
			} else if(left == 2) {
				int f2 = (in[i-1] & (0x03))<<4;
				int l4 = (in[i] & (0xf0))>>4;
				index = (f2 | l4);
				left = 4;
				token += getHexToken(index);
			} else if(left == 4) {
				int f4 = (in[i-1] & (0x0f))<<2;
				int l2 = (in[i] & 0xc0)>>6;
				index = (f4 | l2);
				token += getHexToken(index);
				index = (in[i] & (0x3f));
				left = 0;
				token += getHexToken(index);
			}
			hex.append(token);
		}

		if(left != 0) {
			String lasttoken = "";
			int index = -1;
			if(left == 2) {
				index = (in[in.length - 1] & (0x03));
				index = index<<4;
				lasttoken += getHexToken(index) + "==";
			} else if(left == 4) {
				index = (in[in.length - 1] & (0x0f));
				index = index<<2;
				lasttoken += getHexToken(index) + "=";
			}
			hex.append(lasttoken);
		}
		
		return hex.toString();
	}
	
	public static String hexToBase64(String s) {
		return toBase64(hexToBytes(s));
	}
	
	public static char getHexToken(int index) {
		String tokens = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
		return tokens.charAt(index);
	}
	
	public static byte[] hexToBytes(String hex) {
		int len = (int) Math.ceil(hex.length() / 2.0);
		byte[] b = new byte[len];
		int count = b.length - 1;
		for(int i=hex.length() - 1; i >=0; i-=2) {
			String token = "" + hex.charAt(i);
			if(i-1 >=0) {
				token = hex.charAt(i-1) + token;
			}
			b[count--] = (byte) Integer.parseInt(token, 16);
		}
		return b;
	}
	
	public static String bytesToHex(byte[] b) {
		StringBuilder hex = new StringBuilder();
		for(int i=b.length - 1; i>=0; i--) {
			byte t = b[i];
			int f = t & 0x0f;
			int l = (t & 0xf0)>>4;
			
			String token = toHexToken(f) + toHexToken(l);
			hex.append(token);
		}
		while(hex.length() > 0 && hex.charAt(hex.length() - 1) == '0') {
			hex.deleteCharAt(hex.length() - 1);
		}
		return hex.reverse().toString();
	}
	
	private static String toHexToken(int id) {
		if(id > 10) {
			return "" + (char)('a' + (id - 10));
		}
		return "" + id;
	}
}
