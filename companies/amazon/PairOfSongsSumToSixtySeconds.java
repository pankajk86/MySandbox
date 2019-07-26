package amazon;

public class PairOfSongsSumToSixtySeconds {

	public static void main(String[] args) {
		int[] time = { 30, 20, 150, 100, 40 };
		int result = pairsOfSongsDivisibleBy60(time);
		System.out.println(result);
	}

	private static int pairsOfSongsDivisibleBy60(int[] time) {
		int[] cache = new int[60];
		int result = 0;
		
		for(int t: time) {
			result += cache[(600 - t) % 60];
			cache[t % 60] += 1;
		}
		return result;
	}

}
