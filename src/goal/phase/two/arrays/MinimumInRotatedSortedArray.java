package goal.phase.two.arrays;

public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {

        int a[] = { 4, 5, 6, 7, -1, 1, 2 };
        int min = getMinimum(a);
        System.out.println("Result: " + min);
    }

    private static int getMinimum(int[] a) {

    	int begin = 0, end = a.length - 1;
    	
    	while(begin <= end) {
    		if (begin == end || a[begin] < a[end]) return a[begin];
    		if (end - begin == 1) return Math.min(a[begin], a[end]);
    		
    		int mid = begin + (end - begin) / 2;
    		if(a[begin] <= a[mid]) begin = mid;
    		else end = mid;
    	}
    	return Integer.MIN_VALUE;
    }

}
