package goal.phase.two.arrays;

import java.util.Arrays;

public class LargestNumber {

    public static void main(String[] args) {

    	String[] s = { "3", "30", "34" ,"5" ,"9" };
        String largest = getLargestNumber(s);

        System.out.println("Result: " + largest);
    }

    private static String getLargestNumber(String[] s) {
    	Arrays.sort(s, (s1, s2) -> {
	        String a = s1 + s2, b = s2 + s1;
	        return -1 * a.compareTo(b);
	    });
	    
	    StringBuilder sb = new StringBuilder();
	    Arrays.stream(s).forEach(x -> sb.append(x));
	    while(sb.charAt(0) == '0' && sb.length() > 1) sb.deleteCharAt(0);
	    return sb.toString();
    }

}
