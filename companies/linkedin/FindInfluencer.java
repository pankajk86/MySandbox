package linkedin;

public class FindInfluencer {

	/**
	 * 
	 * Consider an X x Y array of 1's and 0s. The X axis represents "influences" meaning that X influences Y. 
	 * So, for example, if $array[3,7] is 1 that means that 3 influences 7. 
	 * 
	 * An "influencer" is someone who influences every other person, but is not influenced by any other member. 
	 * Given such an array, write a function to determine whether or not an "influencer" exists in the array.  
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[][] a = {
				{1, 1, 0}, 
				{0, 1, 0}, 
				{1, 1, 1}
			};
		int result = findInfluencer(a);
		System.out.println(result);
	}

	private static int findInfluencer(int[][] a) {
		for(int i = 0; i < a.length; i++) {
			int count = 0;
			for(int j = 0; j < a[0].length; j++) {
				if(i != j && a[i][j] == 1 && a[j][i] == 0) count++;
			}
			if(count == a.length - 1) return i;
		}
		return -1;
	}

}
