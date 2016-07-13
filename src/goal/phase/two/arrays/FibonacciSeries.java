package goal.phase.two.arrays;

public class FibonacciSeries {

    public static void main(String[] args) {
        int n = 7;
        int fibonacci = getFibonacciExp(n);
        System.out.println("O(n^2) fibonacci: " + fibonacci);

        int f = getFibonacci(n);
        System.out.println("O(n) fibonacci: " + f);
    }

    private static int getFibonacciExp(int n) {

        if (n <= 1) {
            return n;
        }

        return getFibonacciExp(n - 2) + getFibonacciExp(n - 1);
    }

    private static int getFibonacci(int n) {
        int f[] = new int[n];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i < n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n - 1];
    }

}
