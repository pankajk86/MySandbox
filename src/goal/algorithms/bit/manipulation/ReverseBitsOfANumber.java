package goal.algorithms.bit.manipulation;

public class ReverseBitsOfANumber {

    public static void main(String[] args) {

        int n = 43261596;
        for (int i = 0; i < 16; i++) {
            n = swapBits(n, i, 32 - i - 1);
        }

        System.out.println(n);
    }

    // It is NOT done by me..
    private static int swapBits(int n, int i, int j) {
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;

        if ((a ^ b) != 0) {
            return n ^= (1 << i) | (1 << j);
        }

        return n;
    }

}
