package airbnb;

public class PourWater {

	public static void main(String[] args) {
		int[] heights = { 2, 1, 1, 2, 1, 2, 2 };
		int v = 4, k = 3;
		
		int[] result = pourWater(heights, v, k);
		for(int i: result)
			System.out.print(i + " ");
	}

	private static int[] pourWater(int[] heights, int v, int k) {

		while(v-- > 0) {
			int lowest = k;
			for(int i = k - 1; i >= 0; i--) {
				if(heights[i] > heights[lowest])
					break;
				else if(heights[i] < heights[lowest])
					lowest = i;
			}
			
			if(lowest != k)
				heights[lowest]++;
			else {
				for(int i = k + 1; i < heights.length; i++) {
					if(heights[i] > heights[lowest])
						break;
					else if(heights[i] < heights[lowest])
						lowest = i;
				}
				heights[lowest]++;
			}
		}
		
		return heights;
	}

}
