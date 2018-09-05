package google;

public class MaxProductOfWordLength {

	public static void main(String[] args) {
		String[] words = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
		int result = maxProduct(words);
		System.out.println(result);
	}

	private static int maxProduct(String[] words) {
		if(words == null || words.length == 0)
			return 0;
		
		int length = words.length;
		int[] value = new int[length];
		
		for(int i = 0; i < length; i++) {
			String temp = words[i];
			value[i] = 0;
			for(int j = 0; j < temp.length(); j++) {
				int val = temp.charAt(j) - 'a';
				value[i] |= 1 << val;
			}
		}
		
		int maxProduct = 0;
		for(int i = 0; i < length; i++) {
			for(int j = i + 1; j < length; j++) {
				if((value[i] & value[j]) == 0) {
					int product = words[i].length() * words[j].length();
					maxProduct = Math.max(maxProduct, product);
				}
			}
		}
		return maxProduct;
	}

}
