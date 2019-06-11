package arrays;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class ScratchPad {

	public static void main(String[] args) {
		numberPalindrome();
		initializeTwoDimArray();
		mathCeiling();
		testSHA256();

		testDataTypeSize();

	}

	private static void testDataTypeSize() {
		char c = 'a';
		System.out.println(c + "->" + Integer.toBinaryString(c));
		c = 'z';
		System.out.println(c + "->" + Integer.toBinaryString(c));
		c = '\u0986'; // 0000 0011 1010 1001
		System.out.println(c + "->" + Integer.toBinaryString(c));

		char[] carr = { '\u092A', '\u0902', '\u0915', '\u091C' }; // my first name in Hindi :)
		String s = String.valueOf(carr);
		System.out.println(s);

		c = 'Ҧ';
		int x = (int) c;
		System.out.println(c + "->" + Integer.toBinaryString(c) + " -> " + x);
	}

	private static void testSHA256() {
		String url = "http://www.educative.io/distributed.php?id=design, and http://www.educative.io/distributed.php%3Fid%3Ddesign";
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");// ("SHA-256");
			byte[] encoded = digest.digest(url.getBytes(StandardCharsets.UTF_8));
			BigInteger num = new BigInteger(1, encoded);
			String hash = num.toString(16);

			while (hash.length() < 32)
				hash = "0" + hash;

			System.out.println(hash);

			String base64Encoded = Base64.getEncoder().encodeToString(hash.getBytes("UTF-8"));
			System.out.println(base64Encoded);

			System.out.println(Base64.getEncoder().encodeToString("2".getBytes("UTF-8")));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private static void mathCeiling() {
		int n = 5;
		double result = Math.ceil((double) n / 2);
		System.out.println(result);
	}

	private static void initializeTwoDimArray() {
		int[][] result = new int[3][2];
		int[] a = { 1, 2 };
		result[0] = a;
		result[1] = a;
		result[2] = new int[] { 1, 2 };

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++)
				System.out.print(result[i][j]);
			System.out.println();
		}
	}

	private static void numberPalindrome() {
		int n = 12321;
		int p = n, m = 0;

		while (n > 0) {
			int r = n % 10;
			n /= 10;
			m = 10 * m + r;
		}

		System.out.println(m == p);
	}

}
