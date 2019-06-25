package google;

public class CapacityToShipPackagesWithinDdays {

	public static void main(String[] args) {
		int[] weights = { 3, 2, 2, 4, 1, 4 };
		int d = 3;
		
		int result = shipWithinDdays(weights, d);
		System.out.println(result);
	}

	private static int shipWithinDdays(int[] weights, int d) {
		int left = 0, right = 0;
		
		for(int w: weights) {
			left = Math.max(left, w);
			right += w;
		}
		
		while(left < right) {
			int mid = (left + right) / 2;
			int need = 1, curr = 0;
			
			for(int w: weights) {
				if(curr + w > mid) {
					need++;
					curr = 0;
				}
				curr += w;
			}
			
			if(need > d) left = mid + 1;
			else right = mid;
		}
		
		return left;
	}

}
