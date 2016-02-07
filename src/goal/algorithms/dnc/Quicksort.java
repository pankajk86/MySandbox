package goal.algorithms.dnc;

public class Quicksort {

	public static void main(String[] args) {
		int arr[] = {1, 0, 4, 2, 3, 6, 5, 9, 8, 7};
		quickSort(arr, 0, arr.length-1);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void quickSort(int arr[], int left, int right) {
		int size = right-left+1;
		int i = left, j = right;
		if(size > 1) {
			/*
			 *  we can choose any pivot element in the array.
			 *  Here, we have chosen the middle element as one.
			 */
			int pivot = arr[(left+right)/2];
			
			while(left <= right) {
				/*
				 *  as long as the left element is lesser than the pivot value, 
				 *  we keep on forward, i.e. toward pivot. 
				 */
				while(arr[left] < pivot) {
					left++;
				}
				/*
				 * as long as the right element is greater than the pivot value,
				 * we keep coming backward, i.e. toward pivot.
				 */
				while(arr[right] > pivot) {
					right--;
				}
				
				/*
				 * Now, at this point (after previous two loops), if left < right,
				 * it means that value of pivot is lesser than that of arr[left].
				 * hence we swap the value. 
				 */
				if(left <= right) {
					// swap arr[left] and arr[right]
					int temp = arr[left];
					arr[left] = arr[right];
					arr[right] = temp;
					
					left++; right--;
				}
			}
			
			quickSort(arr, i+1, j);
			quickSort(arr, i, j-1);
		}
	}
}
