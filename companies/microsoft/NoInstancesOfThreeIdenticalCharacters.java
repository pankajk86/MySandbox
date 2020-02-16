package microsoft;

public class NoInstancesOfThreeIdenticalCharacters {

	public static void main(String[] args) {
		String s = "baaabbaabbba";
		int result = noThreeIdentical(s);
		System.out.println(result);
	}

	private static int noThreeIdentical(String s) {
		int moveCount = 0;
        for (int i = 0 ; i < s.length(); i++) {
            int len = 1;
            for (; i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1); i++) {
                len++;
            }
            moveCount += len / 3;
        }
        return moveCount;
	}

}
