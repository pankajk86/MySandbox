package google;

public class EquationsEquality {

	private static int[] uf = new int[26];
	
	public static void main(String[] args) {
		String[] equations = { "f==a", "a==b", "f!=e", "a==c", "b==e", "c==f" };
		boolean result = equationsPossible(equations);
		System.out.println(result);
	}

	private static boolean equationsPossible(String[] equations) {

		for(int i = 0; i < 26; i++) uf[i] = i;
		
		for(String e: equations) {
			if(e.charAt(1) == '=')
				uf[find(e.charAt(0) - 'a')] = find(e.charAt(3) - 'a');
		}
		
		for(String e: equations) {
			if(e.charAt(1) == '!' && find(e.charAt(0) - 'a') == find(e.charAt(3) - 'a'))
				return false;
		}
		
		return true;
	}

	private static int find(int x) {
		if(x != uf[x]) uf[x] = find(uf[x]);
		return uf[x];
	}

}
