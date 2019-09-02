package linkedin;

public class MultiDimSum {

	public static void main(String[] args) {
		int[] dimensions = {3, 3, 3};
		MultiDimArray m = new MultiDimArray(); 
		int sum = multiDimSum(m, dimensions);
		System.out.println(sum);
	}

	private static int multiDimSum(MultiDimArray m, int[] dimensions) {
		int len = dimensions.length;
		int[] index = new int[len];
		int sum = m.get(index); 						// sum = a[0][0][0]
		
		while(true) {
			int curr = len - 1; 						// starting from the end, i.e. 2
			while(curr >= 0) {
				index[curr]++; 							// a[0][0][0] -> a[0][0][1], a[0][0][1] -> a[0][0][2], ...
				if(index[curr] == dimensions[curr]) { 	// if the index has reached the size of the dimension. say size = 3.
					index[curr] = 0; 					// a[0][0][2] -> a[0][0][0]
					curr--;								// from line 18, it will reduce to 1. hence a[0][0][0] -> a[0][1][0] in line 20
				} else {
					sum += m.get(index); 				// keep on adding.
					break;
				}
			}
			if(curr < 0) break;
		}
		
		return sum;
	}

}


class MultiDimArray {
	
	private int[][][] a = 
			{ 
				{ 
					{ 1, 2, 3 }, 
					{ 4, 5, 6 }, 
					{ 7, 8, 9 } 
				}, 
				{ 
					{ 10, 11, 12 }, 
					{ 13, 14, 15 }, 
					{ 16, 17, 18 } 
				},
				{ 
					{ 19, 20, 21 }, 
					{ 22, 23, 24 }, 
					{ 25, 26, 27 } 
				} 
			};
	
	public int get(int[] index) {
		System.out.println("processing: (" + index[0] + ", " + index[1] + ", " + index[2] + ").");
		return a[index[0]][index[1]][index[2]];
	}
}