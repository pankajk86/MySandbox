package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class AccountsMerge {

	public static void main(String[] args) {
		List<List<String>> accounts = new ArrayList<>();
		accounts.addAll(Arrays.asList(
					Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
					Arrays.asList("John", "johnnybravo@mail.com"),
					Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
					Arrays.asList("Mary", "mary@mail.com")
				));
		
		List<List<String>> result = mergeAccounts(accounts);
		System.out.println(result);
	}

	private static List<List<String>> mergeAccounts(List<List<String>> accounts) {
		Map<String, String> emailToMap = new HashMap<>();
		Map<String, String> parents = new HashMap<>();
		Map<String, TreeSet<String>> union = new HashMap<>();
		
		// create the two maps
		for(List<String> act: accounts) {
			for(int i = 1; i < act.size(); i++) {
				emailToMap.put(act.get(i), act.get(0));
				parents.put(act.get(i), act.get(i));
			}
		}
		
		// update parents in each list
		for(List<String> act: accounts) {
			String p = find(act.get(1), parents);
			for(int i = 2; i < act.size(); i++) {
				parents.put(find(act.get(i), parents), p);
			}
		}
		
		// union all lists
		for(List<String> a : accounts) {
            String p = find(a.get(1), parents);
            if (!union.containsKey(p)) 
            	union.put(p, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                union.get(p).add(a.get(i));
        }
		
		// prepare result
		List<List<String>> result = new ArrayList<>();
		for(String s: union.keySet()) {
			List<String> list = new ArrayList<>(union.get(s));
			list.add(0, emailToMap.get(s));
			result.add(list);
		}
		
		return result;
	}
	
	private static String find(String s, Map<String, String> p) {
		while(!p.get(s).equals(s)) {
			p.put(s, p.get(s));
			s = p.get(s);
		}
		return s;
	}

}
