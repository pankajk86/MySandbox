package google;

import java.util.Arrays;

public class QueueReconstruction {

	public static void main(String[] args) {
//		int[][] people = { { 0, 0 }, { 6, 2 }, { 5, 5 }, { 4, 3 }, 
//				{ 5, 2 }, { 1, 1 }, { 6, 0 }, { 6, 3 }, { 7, 0 }, { 5, 1 } };
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		int[][] result = reconstruct(people);

		int[] a = {1,2,3,4,5};
		int index = Arrays.binarySearch(a, 3);
		System.out.println(index >= 0 ? "YES" : "NO");
	}

	//TODO
	private static int[][] reconstruct(int[][] people) {
		return null;
	}



}
