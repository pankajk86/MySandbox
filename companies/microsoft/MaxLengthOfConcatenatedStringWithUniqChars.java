package microsoft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxLengthOfConcatenatedStringWithUniqChars {

	private static int result = 0;
	private static int res = 0;
	
	public static void main(String[] args) {
//		List<String> arr = Arrays.asList("cha", "r", "act", "ers");
		List<String> arr = Arrays.asList("co", "dil", "ity");
		int result = maxLength(arr);
		System.out.println(result);
		
		result = maxLength2(arr);
		System.out.println(result);
	}

    public static int maxLength2(List<String> arr) {
        backTrack(arr, new StringBuilder(), 0);
        return res;
    }
    
    private static void backTrack(List<String> arr, StringBuilder sb, int pos) {
        int len = sb.length();
        res = Math.max(res, len);
        if(pos == arr.size())
            return;
        
        for(int i = pos; i < arr.size(); i++) {
            sb.append(arr.get(i));
            if(isUniq(sb.toString()))
                backTrack(arr, sb, i+1);
            sb.setLength(len);//rollback
        }
    }
    
    private static boolean isUniq(String s) {
        int[] freq = new int[26];
        
        for(char c:s.toCharArray()) {
            if(freq[c - 'a'] > 0)
                return false;
            freq[c - 'a']++;
        }
        return true;
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
