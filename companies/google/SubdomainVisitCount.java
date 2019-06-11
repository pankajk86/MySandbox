package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {

	public static void main(String[] args) {
		String[] cpDomains = { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };
		List<String> result  = subDomainVisits(cpDomains);
		System.out.println(result);
	}

	private static List<String> subDomainVisits(String[] cpDomains) {
		Map<String, Integer> map = new HashMap<>();
		List<String> result = new ArrayList<>();
		
		for(String cp: cpDomains) {
			String[] parts = cp.split(" ");
			int count = Integer.parseInt(parts[0]);
			String domain = parts[1];
			int index = domain.indexOf('.');
			
			while(index > 0) {
				map.put(domain, map.getOrDefault(domain, 0) + count);
				domain = domain.substring(index + 1);
				index = domain.indexOf('.');
			}
			
			map.put(domain, map.getOrDefault(domain, 0) + count);
		}
		
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			result.add(entry.getValue() + " " + entry.getKey());
		}
		
		return result;
	}

}
