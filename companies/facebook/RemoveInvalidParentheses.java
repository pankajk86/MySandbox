package facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {

	public static void main(String[] args) {
		String s = "(a)())()";
		List<String> result = removeInvalidParentheses(s);
		System.out.println(result);
	}

	private static List<String> removeInvalidParentheses(String s) { 
		List<String> result = new ArrayList<>();
		if(s == null || s.isEmpty()) return result;
		
		Set<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		visited.add(s);
		q.add(s);
		boolean found = false;
		
		while(!q.isEmpty()) {
			s = q.poll();
			
			if(isValid(s)) {
				result.add(s);
				found = true;
			}
			if(found) continue;
			
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) != '(' && s.charAt(i) != ')') continue;
				String t = s.substring(0, i) + s.substring(i + 1);
				
				if(!visited.contains(t)) {
					visited.add(t);
					q.add(t);
				}
			}
		}
		
		return result;
	}

	private static boolean isValid(String s) {
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') count++;
			if(s.charAt(i) == ')' && count-- == 0) return false;
		}
		return count == 0;
	}

}
