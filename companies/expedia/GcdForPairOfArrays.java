package expedia;

public class GcdForPairOfArrays {

    public static void main(String[] args) {
        int[] a = {4, 12, 6, 10};
        int[] b = {8, 16, 20, 24};
        int result = countGcdPairs(a, b);
        System.out.println(result);

        result = countGcdPairNaive(a, b);
        System.out.println(result);
    }

    private static int countGcdPairs(int[] a, int[] b) {
        int max = 0, result = 0;
        for (int i : a) max = Math.max(max, i);
        for (int i : b) max = Math.max(max, i);

        int[] freqA = new int[max + 1];
        int[] freqB = new int[max + 1];
        int[] dp = new int[max + 1];

        for (int i : a) freqA[i]++;
        for (int i : b) freqB[i]++;

        for (int i = max; i >= 2; i--) {
            int countA = 0, countB = 0, sub = 0;
            for (int j = i; j <= max; j += i) {
                countA += freqA[j];
                countB += freqB[j];
                sub += dp[j];
            }

            int pairWithGcdI = countA * countB - sub;
            result += pairWithGcdI;
            dp[i] = pairWithGcdI;
        }

        return result;
    }

    private static int countGcdPairNaive(int[] a, int[] b) {
        int result = 0;
        for (int i : a) {
            for (int j : b) {
                if (gcd(i, j) > 1) result++;
            }
        }
        return result;
    }

    private static int gcd(int a, int b) {
        int gcd = 1;

        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }


}
