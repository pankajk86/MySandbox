package facebook;

public class IslandParameter {
	
	public static void main(String[] args) {
		int[][] a = {
				{ 0, 1, 0, 0 },
				{ 1, 1, 1, 0 },
				{ 0, 1, 0, 0 },
				{ 1, 1, 0, 0 }
			};
		
		int result = getParameter(a);
		System.out.println(result);
	}

	private static int getParameter(int[][] a) {
		if(a == null || a.length == 0) return 0;
		
		int result = 0;
		int[][] dirs = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				if(a[i][j] == 1) {
					int count = 0;
					for(int[] dir: dirs) {
						int x = i + dir[0], y = j + dir[1];
						if(x >= 0 && x < a.length && y >= 0 && y < a[0].length && a[x][y] == 1)
							count++;
					}
					result += 4 - count;
				}
			}
		}
		return result;
	}

}
