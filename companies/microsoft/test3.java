package microsoft;

public class test3 {

	public static void main(String[] args) {
		String s = "hot";
		String result = removeOneChar(s);
		System.out.println(result);
	}

	private static String removeOneChar(String s) {
		int len = s.length(); 
        String result = ""; 
  
        // iterate the String  
        for (int i = 0; i < len; i++) { 
  
            // first point where s[i]>s[i+1]  
            if (i < len - 1 && s.charAt(i) > s.charAt(i + 1)) { 
  
                // append the String without  
                // i-th character in it  
                for (int j = 0; j < len; j++) { 
                    if (i != j) { 
                        result += s.charAt(j); 
                    } 
                } 
                return result; 
            } 
        } 
  
        // leave the last character  
        result = s.substring(0, len - 1); 
        return result; 
	}

}
