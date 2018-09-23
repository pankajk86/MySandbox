package facebook;


public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        String result = getMinWindowSubstring(s, t);
        System.out.println(result);
        
    }

    private static String getMinWindowSubstring(String s, String t) {

    	String result = "";
    	
    	if(s == null || s.isEmpty() || t == null || t.isEmpty())
    		return result;
    	
    	int[] smap = new int[256], tmap = new int[256];
    	int i = 0, j = 0, found = 0, length = Integer.MAX_VALUE;
    	
    	for(int k = 0; k < t.length(); k++)
    		tmap[t.charAt(k)]++;
    	
    	while(j < s.length()) {
    		if(found < t.length()) {
    			if(tmap[s.charAt(j)] > 0) {
    				smap[s.charAt(j)]++;
    				if(smap[s.charAt(j)] == tmap[s.charAt(j)])
    					found++;
    			}
    			j++;
    		}
    		while(found == t.length()) {
    			if(j - i < length) {
    				length = j - i;
    				result = s.substring(i, j);
    			}
    			
    			if(tmap[s.charAt(i)] > 0) {
    				smap[s.charAt(i)]--;
    				if(smap[s.charAt(i)] < tmap[s.charAt(i)])
    					found--;
    			}
    			i++;
    		}
    	}
    	
        return result;
    }


}
