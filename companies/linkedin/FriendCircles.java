package linkedin;

import java.util.HashSet;
import java.util.Set;

import graphs.DisjointSet;

public class FriendCircles {

	public static void main(String[] args) {
		int[][] m = {
			{1, 1, 0, 0, 0, 0},
			{1, 1, 1, 0, 0, 0},
			{0, 1, 1, 0, 0, 0},
			{0, 0, 0, 1, 0, 0},
			{0, 0, 0, 0, 1, 1},
			{0, 0, 0, 0, 1, 1}
		};
		
		int result = countFriendCircles(m);
		System.out.println(result);
	}
	
	private static int countFriendCircles(int[][] m) {
		
		Set<Integer> rep = new HashSet<>();
		DisjointSet dset = new DisjointSet();

		for(int i = 0; i < m.length; i++)
			dset.makeSet(i);
		
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++) {
				if(m[i][j] == 1) {
					dset.union(i, j);
				}
			}
		}
		
		for(int i = 0; i < m.length; i++)
			rep.add((int)dset.find(i));
		
		return rep.size();
	}
}
