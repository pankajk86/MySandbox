package arrays;

public class MedianOfSortedArrays {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 10}; // {1, 2}; // { 23, 26, 31, 35 }; // {1, 3, 8, 9, 15}; // 
		int[] b = {}; // {3, 4}; //{ 3, 5, 7, 9, 11, 16 }; // {7, 11, 18, 19, 21, 25}; // 
		
		double result = getMedian(a, b);
		System.out.println(result);
	}

	private static double getMedian(int[] a, int[] b) {
		
		int lenA = a.length, lenB = b.length;
		
		if(lenA == 0 && lenB == 0) {
			return 0.0;
		} else if(lenA == 0) {
			int mid = lenB / 2;
			if(lenB % 2 == 0) {
				return (double) (b[mid-1] + b[mid]) / 2;
			} else {
				return b[mid];
			}
		} else if(lenB == 0) {
			int mid = lenA / 2;
			if(lenA % 2 == 0) {
				return (double) (a[mid-1] + a[mid]) / 2;
			} else {
				return a[mid];
			}
		}
		
		int total = (lenA + lenB + 1) / 2;
		
		if(lenA < lenB) {
			return helper(a, b, lenA / 2, total);
		} else {
			return helper(b, a, lenB / 2, total);
		}
	}

	private static double helper(int[] x, int[] y, int partitionX, int total) {
		
		int partitionY = total - partitionX;
		
		int[] xValues = getValues(x, partitionX);
		int[] yValues = getValues(y, partitionY);
		
		int maxLeftX = xValues[0], minRightX = xValues[1];
		int maxLeftY = yValues[0], minRightY = yValues[1];
		
		if(maxLeftX <= minRightY && maxLeftY <= minRightX) {
			if((x.length + y.length) % 2 == 0) {
				return (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
			} else {
				return Math.max(maxLeftX, maxLeftY);
			}
		} 
		
		if(maxLeftX > minRightY) {
			return helper(x, y, partitionX - 1, total);
		} else {
			return helper(x, y, partitionX + 1, total);
		}
	}
	
	private static int[] getValues(int[] num, int partition) {
		
		int maxLeft, minRight;
		
		if(partition == 0) {
			maxLeft = Integer.MIN_VALUE;
			minRight = num[partition];
		} else if(partition == num.length) {
			maxLeft = num[partition - 1];
			minRight = Integer.MAX_VALUE;
		} else {
			maxLeft = num[partition - 1];
			minRight = num[partition];
		}
		
		return new int[]{maxLeft, minRight};
	}

}
