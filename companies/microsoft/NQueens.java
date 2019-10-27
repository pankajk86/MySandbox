package microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens {

	private static Set<Integer> col = new HashSet<>();
	private static Set<Integer> diag1 = new HashSet<>();
	private static Set<Integer> diag2 = new HashSet<>();
	
	private static boolean[] _col, _diag1, _diag2;
	
	public static void main(String[] args) {
		int n = 4;
		
		long start = System.currentTimeMillis();
		List<List<String>> result = nQueens(n);
		System.out.println("Time taken: " + (System.currentTimeMillis() - start));
		print(result);
		
		start = System.currentTimeMillis();
		result = nQueens2(n);
		System.out.println("Time taken: " + (System.currentTimeMillis() - start));
		print(result);
	}

	/**
	 * BETTER PERFORMANCE
	 * 
	 * @param n
	 * @return
	 */
	private static List<List<String>> nQueens2(int n) {
		_col = new boolean[n]; _diag1 = new boolean[2 * n]; _diag2 = new boolean[2 * n];
		List<List<String>> result = new ArrayList<>();
		dfs2(result, new ArrayList<>(), 0, n);
		return result;
	}

	private static void dfs2(List<List<String>> result, List<String> temp, int row, int n) {
		if(row == n) {
			result.add(new ArrayList<>(temp));
			return;
		}
		
		for(int col = 0; col < n; col++) {
			int id1 = col - row + n, id2 = col + row;
			if(_col[col] || _diag1[id1] || _diag2[id2]) continue;
			
			char[] carr = new char[n];
			Arrays.fill(carr, '.'); carr[col] = 'Q';
			String s = String.valueOf(carr);
			
			temp.add(s);
			_col[col] = true; _diag1[id1] = true; _diag2[id2] = true;
			dfs2(result, temp, row + 1, n);
			temp.remove(temp.size() - 1); 
			_col[col] = false; _diag1[id1] = false; _diag2[id2] = false;
		}
	}

	private static List<List<String>> nQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		dfs(result, new ArrayList<>(), 0, n);
		return result;
	}

	private static void dfs(List<List<String>> result, List<String> temp, int row, int n) {
		if(row == n) {
			result.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i))
				continue;
			
			char[] carr = new char[n];
			Arrays.fill(carr, '.');
			carr[i] = 'Q';
			String s = String.valueOf(carr);
			
			temp.add(s); 
			col.add(i); diag1.add(row + i); diag2.add(row - i);
			dfs(result, temp, row + 1, n);
			temp.remove(temp.size() - 1);
			col.remove(i); diag1.remove(row + i); diag2.remove(row - i);
		}
	}
	
	private static void print(List<List<String>> result) {
		System.out.println("Total Results: " + result.size());
		for(List<String> s: result) {
			for(String s1: s) System.out.println(s1);
			System.out.println("-----------");
		}
	}

}
