package goal.phase.two.arrays;

public class MatchNumbers {

    public static void main(String[] args) {

        makeTheNumbersMatch(2, 11, -7, 13);
    }

    private static void makeTheNumbersMatch(int i, int j, int k, int l) {

        while (i != k) {
            if (i > k) {
                i--;
            } else if (i < k) {
                i++;
            }
        }
        while (j != l) {
            if (j > l) {
                j--;
            } else if (j < l) {
                j++;
            }
        }

        System.out.println("Result: " + i + ", " + j);
    }

}
