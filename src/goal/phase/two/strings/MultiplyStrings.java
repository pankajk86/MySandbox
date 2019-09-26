package goal.phase.two.strings;

public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        
        String result = multiply(num1, num2);
        System.out.println("Result: " + result);
        
        result = multiply2(num1, num2);
        System.out.println("Result: " + result);
    }
    
    private static String multiply2(String s, String t) {
    	int m = s.length(), n = t.length();
    	int[] p = new int[m + n];
    	
    	for(int i = m - 1; i >= 0; i--) {
    		for(int j = n - 1; j >= 0; j--) {
    			int mul = (s.charAt(i) - '0') * (t.charAt(j) - '0');
    			
    			int p1 = i + j, p2 = i + j + 1;
    			mul += p[p2];
    			p[p1] += mul / 10;
    			p[p2] = mul % 10;
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int q: p) {
    		if(!(sb.length() == 0 && q == 0)) sb.append(q);
    	}
    	return sb.length() == 0 ? "0" : sb.toString();
    }

    private static String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] d = new int[num1.length() + num2.length()];

        // multiply each digit and sum at the corresponding positions
        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                d[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();

        // calculate each digit
        for (int i = 0; i < d.length; i++) {
            int mod = d[i] % 10;
            int carry = d[i] / 10;
            if (i + 1 < d.length) {
                d[i + 1] += carry;
            }
            sb.insert(0, mod);
        }

        // remove front 0's
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
