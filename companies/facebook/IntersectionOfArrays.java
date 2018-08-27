package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfArrays {

	public static void main(String[] args) {
		int[] num1 = {4, 9, 5};
		int[] num2 = {9, 4, 9, 8, 4};
		int[] result = intersect(num1, num2);
		
		for(int i: result)
			System.out.print(i + " ");
	}

	private static int[] intersect(int[] num1, int[] num2) {
		
		if(num1.length == 0 || num2.length == 0)
			return new int[0];

		Arrays.sort(num1); // 4, 5, 9
		Arrays.sort(num2); // 4, 4, 8, 9, 9
		
		List<Integer> list = new ArrayList<>();
		int i = 0, j = 0;
		
		while(i < num1.length && j < num2.length) {
			if(num1[i] == num2[j]) {
				list.add(num1[i]);
				i++; j++;
			} else if(num1[i] < num2[j]) {
				i++;
			} else {
				j++;
			}
		}
		
		int[] result = new int[list.size()];
		for(i = 0; i < list.size(); i++) result[i] = list.get(i);
		
		return result;
	}

}
