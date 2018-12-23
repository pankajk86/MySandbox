package google;

public class KthSmallestInSortedMatrix {

	public static void main(String[] args) {
		int[][] a = {
				{ 1,  5,  9 },
				{ 10, 11, 14 },
				{ 12, 13, 15 }
		};
		int k = 8;
		int result = kthMinimum(a, k);
		System.out.println(result);
	}

	private static int kthMinimum(int[][] a, int k) {

		int rows = a.length, cols = a[0].length;
		int start = a[0][0], end = a[rows - 1][cols - 1] + 1;
		
		while(start < end) {
			int mid = start + (end - start) / 2;
			int count = 0, j = cols - 1;
			
			for(int i = 0; i < rows; i++) {
				while(j >= 0 && a[i][j] > mid)
					j--;
				count += (j + 1);
			}
			
			if(count < k) start = mid + 1;
			else end = mid;
		}
		
		return start;
	}

}
