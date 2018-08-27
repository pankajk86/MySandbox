package google;

public class IncreasingTripletSubseaquence {

	public static void main(String[] args) {
		int[] a = { 1, 5, 2, 3 };
		boolean result = increasingTriplet(a);
		System.out.println(result);
	}

	private static boolean increasingTriplet(int[] a) {

		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
		
		for(int i: a) {
			if(i <= small)
				small = i;
			else if(i <= big)
				big = i;
			else return true;
		}

		return false;
	}

}
