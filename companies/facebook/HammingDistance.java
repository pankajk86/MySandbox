package facebook;

public class HammingDistance {

	public static void main(String[] args) {
		int x = 10, y = 1;
		int result = hammingDistance(x, y);
		System.out.println(result);
		
		System.out.println(Integer.toBinaryString(x ^ y));
	}

	private static int hammingDistance(int x, int y) {
		String s  = Integer.toBinaryString(x), t = Integer.toBinaryString(y);
		int result = 0;
		
		int diff = Math.abs(s.length() - t.length());
		StringBuilder sb = new StringBuilder();
		for(int k = 0; k < diff; k++)
			sb.append('0');
		
		if(s.length() < t.length())
			s = sb.toString() + s;
		else if(s.length() > t.length())
			t = sb.toString() + t;
		
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != t.charAt(i))
				result++;
		}
		return result;
	}
	
	public int hammingDistanceBetter(int x, int y) {
        int count = 0;
        int answer = x ^ y;
        // Shift the answer by one bit to the right,
        // if the last digit is 1, increase count by one.
        while (answer!=0)
        {
            answer = answer & (answer-1);
            count++;
        }
        return count;
    }
}
