package goal.arrays;

public class DeleteDuplicatesFromArray {

	public static void main(String[] args) {
		int[] a = { 2, 3, 5, 5, 7, 11, 11, 11, 13 };
		int[] result = removeDuplicates(a);
		for(int i: result) System.out.print(i + " ");
	}

	private static int[] removeDuplicates(int[] a) {
		int i = 1, j = 0;
		
		while(i < a.length) {
			if(a[i] != a[j]) {
				a[++j] = a[i];
            }
            i++;
        }
		
		for(int k = j + 1; k < a.length; k++)
			a[k] = 0;
		
		return a;
	}

}
