package airbnb;

import java.util.ArrayList;
import java.util.List;

public class IpToCIDR {

	public static void main(String[] args) {
		String ip = "255.0.0.7";
		int n = 10;
		
		List<String> result = ipToCIDR(ip, n);
		System.out.println(result);
	}

	private static List<String> ipToCIDR(String ip, int n) {

		long x = 0;
		String[] parts = ip.split("\\.");
		for(String part: parts)
			x = Integer.parseInt(part) + x * 256;
		
		List<String> result = new ArrayList<>();
		while(n > 0) {
			long step = x & -x;
			
			while(step > n)
				step /= 2;
			
			result.add(longToIP(x, step));
			x += step; n -= step;
		}
		
		return result;
	}

	private static String longToIP(long x, long step) {

		int[] result = new int[4];
		result[0] = (int) x & 255; x >>= 8;
		result[1] = (int) x & 255; x >>= 8;
		result[2] = (int) x & 255; x >>= 8;
		result[3] = (int) x;
		
		int len = 33;
		
		while(step > 0) {
			len--; step /= 2;
		}
		
		return result[3] + "." + result[2] + "." + result[1] + "." + result[0] + "/" + len;
	}

}
