package goal.algorithms.bit.manipulation;

public class CheckIntegerPowerOfTwo {

    public static void main(String[] args) {

        int n = 36; // 32
        n = n & (n - 1);

        if (n == 0) {
            System.out.println("Power of 2");
        } else {
            System.out.println("Not power of 2");
        }
        
    }

}
