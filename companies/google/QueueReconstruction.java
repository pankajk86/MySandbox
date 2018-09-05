package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class QueueReconstruction {

	public static void main(String[] args) {
		int[][] people = { { 0, 0 }, { 6, 2 }, { 5, 5 }, { 4, 3 }, 
				{ 5, 2 }, { 1, 1 }, { 6, 0 }, { 6, 3 }, { 7, 0 }, { 5, 1 } };
		int[][] result = reconstruct(people);

		for (int i = 0; i < result.length; i++)
			System.out.println(result[i][0] + ", " + result[i][1]);
	}

	private static int[][] reconstruct(int[][] people) {

		int rows = people.length;
		int cols = rows > 0 ? people[0].length : 0;
		int[][] result = new int[rows][cols];

		if (rows > 0 && cols > 0) {
			List<Group> groups = createGroups(people);

			List<int[]> list = new LinkedList<>();
			Group maxHeight = groups.get(groups.size() - 1);
			list.addAll(maxHeight.elems);

			for (int i = groups.size() - 2; i >= 0; i--) {
				Group g = groups.get(i);

				for (int[] p : g.elems) {
					list.add(p[1], p);
				}
			}

			for (int i = 0; i < list.size(); i++) {
				result[i] = list.get(i);
			}
		}

		return result;
	}

	private static List<Group> createGroups(int[][] people) {

		List<Group> groups = new ArrayList<>();
		Map<Integer, List<int[]>> map = new HashMap<>();

		for (int[] p : people) {
			List<int[]> list = map.getOrDefault(p[0], new ArrayList<>());
			list.add(p);
			map.put(p[0], list);
		}

		for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
			List<int[]> value = entry.getValue();
			
			Collections.sort(value, new Comparator<int[]>() {

				@Override
				public int compare(int[] p1, int[] p2) {
					if(p1[0] < p2[0]) return -1;
					else if(p1[0] > p2[0]) return 1;
					else {
						if(p1[1] < p2[1]) return -1;
						else if(p1[1] > p2[1]) return 1;
						else return 0;
					}
				}
			});
			
			Group g = new Group(entry.getKey(), entry.getValue());
			groups.add(g);
		}

		return groups;
	}

}

class Group {
	int height;
	List<int[]> elems;

	public Group(int height, List<int[]> elems) {
		this.height = height;
		this.elems = elems;
	}
}
