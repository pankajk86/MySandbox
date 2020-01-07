package microsoft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLengthOfConcatenatedStringWithUniqChars {

	private static int result = 0;
	
	public static void main(String[] args) {
		List<String> arr = Arrays.asList("cha", "r", "act", "ers");
		int result = maxLength(arr);
		System.out.println(result);
	}

	private static int maxLength(List<String> arr) {
		dfs(arr, "", 0);
		return result;
	}

	private static void dfs(List<String> arr, String path, int index) {
		boolean isUniq = hasUniqueChars(path);
		if(isUniq) result = Math.max(result, path.length());
		if(index == arr.size() || !isUniq) return;
		
		for(int i = index; i < arr.size(); i++)
			dfs(arr, path + arr.get(i), i + 1);
	}

	private static boolean hasUniqueChars(String path) {
		Set<Character> set = new HashSet<>();
		for(char c: path.toCharArray()) {
			if(set.contains(c)) return false;
			set.add(c);
		}
		return true;
	}

}
