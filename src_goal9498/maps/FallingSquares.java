package maps;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FallingSquares {

	public static void main(String[] args) {
		int[][] a = {
				{1, 2},
				{2, 3}, 
				{6, 1},
				{4, 2},
				{7, 3}, 
				{8, 10}
		};
		
		List<Integer> result = fallingSquares(a);
		System.out.println(result);
	}

	private static List<Integer> fallingSquares(int[][] positions) {

		List<Integer> result = new ArrayList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int max = 0;
		
		map.put(0, 0);

		for(int[] position: positions) {
			int start = position[0], end = start + position[1];
			
			Integer key = map.floorKey(start);
			int height = map.get(key);
			key = map.higherKey(key);
			
			while(key != null && key < end) {
				height = Math.max(height, map.get(key));
				key = map.higherKey(key);
			}
			height += position[1];
			
			max = Math.max(max, height);
			result.add(max);
			
			// update new segment and delete previous segments among the range
			int tail = map.floorEntry(end).getValue();
			map.put(start, height);
			map.put(end, tail);
			key = map.higherKey(start);
			
			while(key != null && key < end) {
				map.remove(key);
				key = map.higherKey(key);
			}
		}
		
		return result;
	}

}
