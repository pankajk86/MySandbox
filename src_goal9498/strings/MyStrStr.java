package strings;

import java.util.Arrays;

public class MyStrStr {

	public static void main(String[] args) {
		test1();
	}

	private static void test1() {
		String s = "algorithm", t = "logarithm";
		char[] sarr = s.toCharArray(), tarr = t.toCharArray();
		Arrays.sort(sarr); Arrays.sort(tarr);
		s = String.valueOf(sarr); t = String.valueOf(tarr);
		System.out.println(s.equals(t));
	}

}
