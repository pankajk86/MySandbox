package goal.algorithms.strings;

public class KMPAlgorithmStringSrearch {
	
	public static void main(String[] args) {

		String T = "abacdadedgagaehaeheka";
		String P = "adedgagaeha";
		
		int startLoc = searchKMP(T, P);
		System.out.println("StartLocation: " + startLoc);
	}
	
	private static int searchKMP(String t, String p) {
		char[] tArray = t.toCharArray();
		char[] pArray = p.toCharArray();
		int F[] = createPrefixTable(pArray);
		
		int i = 0, j = 0, n = t.length(), m = p.length();
		
		while(i < n) {
			// if the substring is matching
			if(tArray[i] == pArray[j]) {
				// if the current value of j is (m-1), it means we have found the pattern in the text
				// and in this case, we just return (i-j), for it will be the beginning index of the pattern.
				if(j == m-1) {
					return (i-j);
				}
				// else we will keep looking forward.
				else {
					i++; j++;
				}
			} 
			// in this case, we will lookup the Prefix table.
			else if (j > 0) {
				j = F[j-1];
			} else {
				i++;
			}
		}
		
		return -1;
	}

	public static int[] createPrefixTable(char p[]) {
		int m = p.length;
		int i = 1, j = 0;
		int F[] = new int[p.length];
		F[0] = 0;
		
		while(i<m) {
			if(p[i] == p[j]) {
				F[i] = j+1;
				i++; j++;
			} else if (j > 0) {
				j = F[j-1];
			} else {
				F[i] = 0;
				i++;
			}
		}
		
		return F;
	}

}
