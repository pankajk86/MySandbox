package facebook;

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeros {

	public static void main(String[] args) {
		int[][] m = {
				{0,1,2,0},
				{3,4,5,2},
				{1,3,1,5}
		};
		setZeros(m);
		
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++)
				System.out.print(m[i][j] + " ");
			System.out.println();
		}
	}

	private static void setZeros(int[][] m) {
		int r = m.length, c = m[0].length;
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(m[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		for(int i = 0; i < rows.size(); i++) {
			for(int j = 0; j < c; j++) {
				m[rows.get(i)][j] = 0;
			}
		}
		
		for(int j = 0; j < cols.size(); j++) {
			for(int i = 0; i < r; i++) {
				m[i][cols.get(j)] = 0;
			}
		}
	}

}
