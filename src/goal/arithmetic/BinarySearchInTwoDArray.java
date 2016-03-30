package goal.arithmetic;

public class BinarySearchInTwoDArray {

	public static void main(String[] args) {

		int [][] arr = {
		                {1,   3,  5,  7},
		                {10, 11, 16, 20},
		                {23, 30, 34, 50}
				};
		
//		int [][] arr = {{1}};
		int target = 4;
		
		int rowIndex = getRow(arr, 0, arr.length-1, target); 
		int columnIndex = getColumn(arr[rowIndex], 0, arr[0].length-1, target);
		
		System.out.println("Row: " + rowIndex + ", Column:" + columnIndex);
	}

	private static int getRow(int[][] arr, int low, int high, int target) {
		
		if(low == high) {
			return low;
		}
		
		int mid = low + (high-low)/2;
		
		if(arr[mid][0] <= target && mid == high || arr[mid][0] <= target && arr[mid+1][0] > target) {
			return mid;
		}
		
		if(arr[mid][0] > target) {
			return getRow(arr, low, mid-1, target);
		}else {
			return getRow(arr, mid+1, high, target);
		}
	}
	
	private static int getColumn(int[] arr, int low, int high, int target) {
		
		if(low == high) {
			if(arr[low] == target) {
				return low;
			} else {
				return -1;
			}
		}
		
		if(low > high) {
			return -1;
		}
		
		int mid = low + (high - low)/2;
		
		if(arr[mid] == target) {
			return mid;
		}
		
		if(arr[mid] < target) {
			return getColumn(arr, mid+1, high, target);
		}else {
			return getColumn(arr, low, mid-1, target);
		}
		
	}

}
