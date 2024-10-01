package google;

import java.util.Arrays;

public class BagOfTokens {

    public static void main(String[] args) {
        int[] tokens = {100, 200, 300, 400};
        int power = 200;

        int result = maxScore(tokens, power);
        System.out.println(result);
    }

    private static int maxScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int result = 0, score = 0;

        for (int l = 0, r = tokens.length - 1; l <= r; ) {
            if (power >= tokens[l]) {
                score++;
                power -= tokens[l++];
                result = Math.max(result, score);
            } else if (score > 0) {
                score--;
                power += tokens[r--];
            } else break;
        }
        return result;
    }
}
