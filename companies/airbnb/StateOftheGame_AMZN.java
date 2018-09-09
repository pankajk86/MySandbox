package airbnb;

import java.util.ArrayList;
import java.util.List;

public class StateOftheGame_AMZN {

	public static void main(String[] args) {
		int[] a = {1, 1, 1, 0, 1, 1,1,1}; //{1, 0, 0, 0, 0, 1, 0, 0 };
		int days = 2;
		
		List<Integer> result = solution(a, days);
		System.out.println(result);
	}

	private static List<Integer> solution(int[] a, int days) {
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < days; i++) {
			int[] cache = new int[a.length];

			for(int j = 0; j < a.length; j++) {
				if(j == 0) {
					if(a[j + 1] == 0) cache[j] = 0;
					else cache[j] = 1;
				} else if(j == a.length - 1) {
					if(a[j - 1] == 0) cache[j] = 0;
					else cache[j] = 1;
				} else {
					if((a[j - 1] == 0 && a[j + 1] == 0) || (a[j - 1] == 1 && a[j + 1] == 1))
						cache[j] = 0;
					else cache[j] = 1;
				}
			}
			a = cache;
		}
		
		for(int i: a) list.add(i);
		
		return list;
	}

}
