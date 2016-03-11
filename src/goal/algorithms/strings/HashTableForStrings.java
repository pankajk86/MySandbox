package goal.algorithms.strings;

public class HashTableForStrings {
	// NEED TO BE IMPLEMENTED
	public static void main(String[] args) {

		String str = "Pankaj Kumar";
		int n = 32; // map size
		int hash = hash(str.hashCode());
		int index = hash & (n-1);
		
		System.out.println(index);
	}
	
	private static int hash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

}
