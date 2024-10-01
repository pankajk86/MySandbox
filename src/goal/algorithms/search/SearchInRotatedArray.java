package goal.algorithms.search;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int[] arr = { 12, 13, 14, 15, 1, 2, 3, 4, 5, 6 };
        int searchItem = 15;
        
        int result = search(arr, searchItem);
        System.out.println(result);
    }

    private static int search(int[] a, int target) {
    	int left = 0, right = a.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(a[mid] == target) return mid;
            
            if(a[left] <= a[mid]) {
                if(target >= a[left] && target < a[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if(target > a[mid] && target <= a[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
	}

}
