package arrays;

public class DeleteDuplicatesFromArray {

	public static void main(String[] args) {
		int a[] = { 2, 3, 5, 5, 7, 11, 11, 11, 13 };
		int[] result = moveZero(deleteDuplicates(a));

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}
		System.out.println("\n--------");
		
		int[] b = {0, 1, 0, 3, 12, 0, 0, 0, 4, 5, 0};
		result = moveZeroInOrder(b);
		
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + ", ");
		}
	}

	private static int[] deleteDuplicates(int[] a) {

		int i = 0, j = 1, k = -1;

		while (j < a.length) {
			if (a[i] != a[j]) {
				i++;
				j++;
			} else {
				while (a[i] == a[j]) {
					j++;
				}

				for (k = i + 1; k < j; k++) {
					a[k] = 0;
				}
				i = k + 1;
				j += 1;
			}
		}

		return a;
	}

	private static int[] moveZero(int[] t) {

		int left = 0, right = t.length - 1;
		boolean done = false;

		while (!done) {
			while (t[left] != 0) {
				left++;
			}
			while (t[right] == 0) {
				right--;
			}

			if (left > right) {
				done = true;
			} else {
				int temp = t[left];
				t[left] = t[right];
				t[right] = temp;
			}
		}
		return t;
	}
	
	private static int[] moveZeroInOrder(int[] a) {
		
		int index = 0;
		
		for(int i=0; i < a.length; i++) {
			if(a[i] != 0) {
				a[index] = a[i];
				index++;
			}
		}
		
		if(index < a.length) {
			for(int i=index; i< a.length; i++) {
				a[i] = 0;
			}
		}
		
		return a;
	}
}
