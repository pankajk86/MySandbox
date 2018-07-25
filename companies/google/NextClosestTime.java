package google;

import java.util.HashSet;
import java.util.Set;

public class NextClosestTime {

	public static void main(String[] args) {
		String time = "11:11";
		String result = nextClosestTime(time);
		System.out.println(result);
	}

	private static String nextClosestTime(String time) {

		String[] parts = time.split(":");
		int num = Integer.parseInt(parts[0]) * 100 + Integer.parseInt(parts[1]);
		Set<Integer> set = new HashSet<>();

		for(char c: time.toCharArray()) {
			if(c != ':') {
				set.add(Integer.parseInt(String.valueOf(c)));
			}
		}
		
		if(set.size() == 1)
			return time;
		
		int next = 0;
		
		for(next = num + 1; next <= 2400; next++) {
			
			if(next % 100 == 60) {
				next = (next / 100 + 1) * 100;
				
				if(next == 2400) {
					next = 0; continue;
				}
			}
			
			if(next < 1000 && !set.contains(0)) {
				continue;
			}
			
			int temp = next, flag = 0;
			
			while(temp > 0) {
				int t = temp % 10;
				temp /= 10;
				if(!set.contains(t)) {
					flag = 1;
					break;
				}
			}
			
			if(flag == 0) {
				break;
			}
		}
		
		int minutes = next % 100;
		int hours = next / 100;
		
		String strMinutes = minutes < 10 ? "0" + minutes : "" + minutes;
		String strHours = hours < 10 ? "0" + hours : "" + hours;
		
		return (strHours + ":" + strMinutes);
	}

}
