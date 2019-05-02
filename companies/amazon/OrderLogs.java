package amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderLogs {

	public static void main(String[] args) {
		
		String[] logs = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo","a2 act car"};
		String[] result = order(logs);
		
		for(String s: result)
			System.out.print(s + ", ");
	}

	private static String[] order(String[] logs) {
		
		List<String> letterLogs = new ArrayList<>();
		List<String> digitLogs = new ArrayList<>();
		
		for(String log: logs) {
			char l = log.charAt(log.indexOf(" ") + 1);
			
			if(l >= '0' && l <= '9')
				digitLogs.add(log);
			else letterLogs.add(log);
		}
		
		Collections.sort(letterLogs, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int index1 = s1.indexOf(" "), index2 = s2.indexOf(" "); 
				String parts11 = s1.substring(0, index1), parts12 = s1.substring(index1 + 1);
				String parts21 = s2.substring(0, index2), parts22 = s2.substring(index2 + 1);
				
				if(parts12.compareTo(parts22) == 0) return parts11.compareTo(parts21);
				return parts12.compareTo(parts22);
			}
		});
		
		String[] result = new String[logs.length];
		int i = 0;
		
		for(String l: letterLogs)
			result[i++] = l;
		
		for(String l: digitLogs)
			result[i++] = l;
		return result;
	}

}
