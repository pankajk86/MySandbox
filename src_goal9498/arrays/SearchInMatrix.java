package arrays;

public class SearchInMatrix {

	public static void main(String[] args) {
		int[][] a = {
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};
		
		int target = 15;
		boolean result = searchMatrix(a, target);
		System.out.println(result);
	}

	private static boolean searchMatrix(int[][] a, int target) {
		
		int rowSize = a.length;
		int colSize = rowSize > 0 ? a[0].length : 0;
		int start = 0, end = rowSize * colSize - 1;
		
		while(start <= end) {
			
			int mid = (start + end) / 2;
			int x = mid / colSize, y = mid % colSize;
			
			if(a[x][y] == target)
				return true;
			else if(a[x][y] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return false;
	}

}
