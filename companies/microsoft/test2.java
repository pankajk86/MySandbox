package microsoft;

public class test2 {

	public static void main(String[] args) {
		String s = "baaabbabbb";
		int result = findLongestSemiAlteringSubstring(s);
		System.out.println(result);
	}

	private static int findLongestSemiAlteringSubstring(String str) {
        int len = 0;
        if(str == null) return 0;
        if(str.length() < 3) return str.length();
        for(int i=2,j=0;i<str.length(); ++i) {
            if(str.charAt(i) == str.charAt(i-1) && str.charAt(i) == str.charAt(i-2))
                j = i-1;
            len = Math.max(len, i-j+1);
        }
        return len;
    }
}
