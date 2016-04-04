package goal.algorithms.bit.manipulation;

public class CountOfSetBits {

    public static void main(String[] args) {

        int n = 165;
        int count = 0;

        for (int i = 1; i <= 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }

        System.out.println("# of set bits: " + count);
    }
}
