package com.algorithms.sorting;

public class MergeSort {

	public static void main(String[] args) {
		int A[] = {3, 1, 4, 2, 6, 5, 8, 7};
		mergeSort(A, 0, A.length-1);
		
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}

	public static void mergeSort(int A[], int left, int right) {
		if(left < right) {
			int mid = (left + right)/2;
			mergeSort(A, left, mid);
			mergeSort(A, mid+1, right);
			merge(A, left, mid+1, right);
		}
	}

	private static void merge(int[] A, int left, int mid, int right) {
		int j = left, k = mid-1;
		int temp[] = new int[A.length];
		int num = right - left + 1;
		
		while(left <= k && mid <= right) {
			if(A[left] <= A[mid]) {
				temp[j] = A[left];
				left++;
			} else {
				temp[j] = A[mid];
				mid++;
			}
			j++;
		}
		
		while(left <= k) {
			temp[j] = A[left];
			left++; 
			j++;
		}
		
		while(mid <= right) {
			temp[j] = A[mid];
			mid++; 
			j++;
		}
		
		for(int i=0; i< num; i++) {
			A[right] = temp[right];
			right--;
		}
	}
}
