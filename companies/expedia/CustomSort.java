package expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomSort {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
//		list.addAll(Arrays.asList(4, 5, 6, 5, 4, 3));
		list.addAll(Arrays.asList(5, 3, 1, 2, 2, 4));
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i: list) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {
				if(map.get(i1) < map.get(i2)) return -1;
				else if(map.get(i1) > map.get(i2)) return 1;
				else {
					if(i1 < i2)  return -1;
					else if(i1 > i2) return 1;
					else return 0;
				}
			}
		});
		
		System.out.println(list);
	}

}
