package com.algorithms.search;

public class BinarySearch {

	public static void main(String[] args) {
		
		int arr[] = {1, 0, 4, 2, 3, 6, 5, 9, 8, 7};
		int item = 5;
		int index = binarySearch(arr, item);
		System.out.println("Item " + item + " found at index: " + index);
	}

	public static int binarySearch(int arr[], int item) {
		int low = 0, high = arr.length-1;
		
		while(low < high) {
			int mid = (low + (high-low)/2);
			if(arr[mid]==item) {
				return mid;
			} else if(arr[mid] < item) {
				low = mid++;
			} else {
				high = mid--;
			}
		}
		return -1;
	}
}
