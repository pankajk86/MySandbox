package google;

import java.util.Random;

public class Rand7UsingRand5 {

	public static void main(String[] args) {
		for(int i = 0; i < 20; i++)
			System.out.println(rand7());
	}
	
	private static int rand7() {
		int part1 = (rand5() - 1) * 5; // generates 0, 5, 10, 15, 20
		int part2 = rand5() - 1; // generates 0, 1, 2, 3, 4
		int val = part1 + part2; // giving the range from 0 to 24 with equal probability
		return val >= 21 ? rand7() : val % 7 + 1;
	}

	private static int rand5() {
		return new Random().nextInt(5) + 1;
	}

}
