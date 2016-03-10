package goal.algorithms.strings;

public class HashTableForStrings {
	// NEED TO BE IMPLEMENTED
	public static void main(String[] args) {

		String str = "abc";
		int hash = str.hashCode();
		int index = hash & 15;
		
		System.out.println(index);
	}

}
