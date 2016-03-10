package goal.arithmetic;

import java.util.Set;
import java.util.TreeSet;

public class PythagoreanTriplets {

	public static void main(String[] args) {
		
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		printPythagoreanTriplets(arr);
	}

	private static void printPythagoreanTriplets(int[] arr) {
		
		Set<Integer> squareIntegers = new TreeSet<Integer>();
		
		for(int i=0; i<arr.length; i++) {
			int square = (int) Math.pow(arr[i], 2);
			arr[i] = square;
			squareIntegers.add(square);
		}
		
		for(int i=0; i<arr.length; i++) {
			for(int j= (i+1); j<arr.length; j++) {
				int biggest = arr[i] + arr[j];
				
				if(squareIntegers.contains(biggest)) {
					System.out.println(
							"(" + (int) Math.sqrt(arr[i]) + 
							", " + (int) Math.sqrt(arr[j]) + 
							", " + (int) Math.sqrt(biggest) + ")");
				}
			}
		}
	}

}
