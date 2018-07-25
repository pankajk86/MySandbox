package contests;

public class Week93 {
	
	public static void main(String[] args) {
		int result = binaryGap(6);
		System.out.println(result);
		
		// TIME LIMIT EXCEEDED
		boolean result2 = stringPermutations("", String.valueOf(116617277)); // 679213508
		System.out.println(result2);
	}
	
	
	private static boolean stringPermutations(String prefix, String str) {
        boolean result = false;
		int n = str.length();

        if (n == 0 && prefix.charAt(0) != '0') {
        	int num = Integer.parseInt(prefix);
            result = (num & (num - 1)) == 0;
            if(result) {
            	return result;
            }
        }

        for (int i = 0; i < n; i++) {
            result = stringPermutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            if(result) {
            	break;
            }
        }
        
        return result;
    }

	
	private static int binaryGap(int N) {

		String bString = Integer.toBinaryString(N);
		
		int maxGap = 0;
		
		for(int i = 0, j = 1; j < bString.length(); ) {
			if(bString.charAt(j) == '1') {
				maxGap = Math.max(maxGap, j-i);
				i = j; j++;
			} else {
				while(bString.charAt(j) != '1') {
					j++;
					if(j == bString.length()) {
						break;
					}
				}
			}
		}
		
		return maxGap;
	}

}
