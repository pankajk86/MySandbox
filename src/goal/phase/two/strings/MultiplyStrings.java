package goal.phase.two.strings;

public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        
        String result = multiply(num1, num2);
        System.out.println("Result: " + result);
    }
    
    private static String multiply(String s, String t) {
    	int m = s.length(), n = t.length();
    	int[] cache = new int[m + n];
    	
    	for(int i = m - 1; i >= 0; i--) {
    		for(int j = n - 1; j >= 0; j--) {
    			int mul = (s.charAt(i) - '0') * (t.charAt(j) - '0');
    			
    			int p1 = i + j, p2 = i + j + 1;
    			mul += cache[p2];
    			cache[p1] += mul / 10;
    			cache[p2] = mul % 10;
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i: cache) {
    		if(!sb.isEmpty() || i > 0) sb.append(i);
    	}
    	return sb.isEmpty() ? "0" : sb.toString();
    }
}
