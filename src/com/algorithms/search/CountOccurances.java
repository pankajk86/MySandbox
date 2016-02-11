package com.algorithms.search;

public class CountOccurances {

	public static void main(String[] args) {
		int arr[] = {1,1,2,2,2,3,3,3,3,4,4,4,4,4};
		int findCount = 3;
		int startIndex = searchStart(arr, 0, arr.length-1, findCount);
		int endIndex = searchEnd(arr, 0, arr.length-1, findCount);
		int totalCount = endIndex - startIndex + 1;
		
		System.out.println("Total Count of Occurances for " + findCount + " is: " + totalCount);
	}

	/**
	 * This returns the index of the first occurrence of "data" in the sorted array "arr".
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 * @param data
	 * @return
	 */
	private static int searchStart(int[] arr, int left, int right, int data) {
		if (left > right) {
			return -1;
		}
		
		int mid = left + (right-left)/2;
		
		if(mid==left && arr[mid] == data || arr[mid-1] < data && arr[mid] == data) {
			return mid;
		}else {
			if (data <= arr[mid]) {
				return searchStart(arr, left, mid-1, data);
			}else {
				return searchStart(arr, mid+1, right, data);
			}
		}
	}

	/**
	 * This returns the index of the last occurrence of "data" in the sorted array "arr".
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 * @param data
	 * @return
	 */
	private static int searchEnd(int[] arr, int left, int right, int data) {
		if (left > right) {
			return -1;
		}
		
		int mid = left + (right-left)/2;
		
		if(mid==right && arr[mid] == data || arr[mid+1] > data && arr[mid] == data) {
			return mid;
		}else {
			if (data >= arr[mid]) {
				return searchEnd(arr, mid+1, right, data);
			}else {
				return searchEnd(arr, left, mid-1, data);
			}
		}
	}
}
