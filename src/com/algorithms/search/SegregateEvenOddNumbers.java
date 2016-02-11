package com.algorithms.search;

public class SegregateEvenOddNumbers {

	public static void main(String[] args) {
		int arr[] = {12, 34, 45, 27, 24, 8, 90, 3, 14, 33};
		segrateNumbers(arr, 0, arr.length-1);
		
		for(int i=0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/**
	 * This is a variant of "Dutch National Flag problem".
	 * 
	 * @param arr
	 * @param left
	 * @param right
	 */
	private static void segrateNumbers(int[] arr, int left, int right) {
		
		while(left < right) {
			// keep moving towards right, until find an odd number
			while(arr[left]%2 != 1) {
				left++;
			}
			
			// keep moving towards left, until find an even number
			while(arr[right]%2 != 0) {
				right--;
			}
			
			// if so, swap them
			if(left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}	
		}	
	}

}
