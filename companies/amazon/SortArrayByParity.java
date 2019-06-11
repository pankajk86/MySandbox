package amazon;

public class SortArrayByParity {

	public static void main(String[] args) {
		int[] a = { 5, 7, 6, 3, 8, 1, 1, 2, 5, 4 };
		int[] result = sortByParity(a);

		for (int i : result)
			System.out.print(i + " ");
	}

	private static int[] sortByParity(int[] a) {

		for(int i = 0, j = a.length - 1; i <= j; ) {
			if(a[i] % 2 == 0 && a[j] % 2 == 0) 
				i++;
			else if(a[i] % 2 != 0 && a[j] % 2 == 0) {
				swap(a, i, j);
				i++;
			} else if(a[i] % 2 == 0 && a[j] % 2 != 0) {
				i++; j--;
			} else if(a[i] % 2 != 0 && a[j] % 2 != 0) {
				j--;
			}
		}

		return a;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
