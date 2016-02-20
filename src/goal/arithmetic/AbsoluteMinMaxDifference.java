package goal.arithmetic;

import goal.algorithms.dnc.MergeSort;

public class AbsoluteMinMaxDifference {

	public static void main(String[] args) {
		int arr[] = {-4, 2, 3, 9, -200, 0, 7, 17, 91,};
		
		MergeSort.mergeSort(arr, 0, arr.length-1);
		int minDiff = getMinAbsDifference(arr);
		int maxDiff = getMaxAbsDifference(arr);
		
		System.out.println("Minimum Absolute Difference: " + minDiff);
		System.out.println("Maximum Absolute Difference: " + maxDiff);
	}

	private static int getMinAbsDifference(int arr[]) {
		int minDiff = Integer.MAX_VALUE;
		
		for(int i=0; i<(arr.length-1); i++) {
			int val = arr[i+1]-arr[i];
			if(val < minDiff) {
				minDiff = val;
			}
		}
		
		return minDiff;
	}
	
	private static int getMaxAbsDifference(int arr[]) {
		int maxDiff = Integer.MIN_VALUE;
		
		for(int i=0; i<(arr.length-1); i++) {
			int val = arr[i+1]-arr[i];
			if(val > maxDiff) {
				maxDiff = val;
			}
		}
		
		return maxDiff;
	}
}
