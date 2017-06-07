package crypto.challenges.set1;

public class BitwiseUtils {
	public static byte[] xor(byte[] a, byte[] b) {
		assert(a.length == b.length && a.length > 0);
		byte[] result = new byte[a.length];
		
		for(int i=0; i < a.length; i++) {
			result[i] = (byte) (a[i] ^ b[i]);
		}
		return result;
	}
	
	public static byte[] xor(byte[] a, byte key) {
		byte[] result = new byte[a.length];
		
		for(int i=0; i < a.length; i++) {
			result[i] = (byte) (a[i] ^ key);
		}
		return result;
	}
}
