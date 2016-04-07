package goal.algorithms.recursion;

public class CountPermutations {

    public static void main(String[] args) {

        int num = 1123;
        int count = getCountPermutations(num);
        System.out.println("# of permutations: " + count);
    }

    private static int getCountPermutations(int num) {

        if (num < 10) {
            return 1;
        }

        int lastTwo = num % 100;

        if (lastTwo <= 26) {
            return getCountPermutations(num / 100) + getCountPermutations(num / 10);
        } else {
            return getCountPermutations(num / 10);
        }
    }

}
