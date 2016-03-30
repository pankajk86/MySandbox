package goal.algorithms.search;

public class FirstElementInDuplicateSortedArray {

	public static void main(String[] args) {
		int arr[] = {5, 7, 7, 8, 8, 10};
		int searchItem = 8;
		int index = searchFirst(arr, 0, arr.length-1, searchItem);
		System.out.println("Index of first " + searchItem + " is: " + index);
		
		int end = searchEnd(arr, 0, arr.length-1, searchItem);
		System.out.println(end);
	}

	private static int searchFirst(int[] arr, int left, int right, int data) {
		if(left > right) {
			return -1;
		}
		
		int mid = left + (right-left)/2;
		
		/*
		 * Here, we have put two conditions:
		 * 1. This is a special case, when the searched item is the very beginning of the list.
		 * For this, we don't have any further elements before the very first element to compare with
		 * (that, this is greater than the element before that).
		 * That's why, we have put the condition: (mid == left).
		 * 
		 * 2. With the explanation of 1., the second condition is simpler.
		 * That is, we want to make sure that element before the current element, i.e. arr[mid] is lesser than data,
		 * hence, arr[mid] is the first element with data as it's value.
		 */
		if(arr[mid] == data && mid == left || arr[mid] == data && arr[mid-1] < data) {
			return mid;
		} else {
			// here, we are giving the left half preference
			if (data <= arr[mid]) {
				return searchFirst(arr, left, mid-1, data);
			}else {
				return searchFirst(arr, mid+1, right, data);
			}
		}
	}
	
	private static int searchEnd(int[] arr, int left, int right, int data) {
		if(left > right) {
			return -1;
		}
		
		int mid = left + (right-left)/2;
		
		if(arr[mid] == data && mid == right || arr[mid] == data && arr[mid+1] > data) {
			return mid;
		} else {
			// here, we are giving the right half preference
			if (data < arr[mid]) {
				return searchEnd(arr, left, mid-1, data);
			}else {
				return searchEnd(arr, mid+1, right, data);
			}
		}
	}
}
