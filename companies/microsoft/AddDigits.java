package microsoft;

public class AddDigits {

    public static void main(String[] args) {
        int n = 134;
        int result = addDigits(n);
        System.out.println(result);

        result = addDigits2(n);
        System.out.println(result);
    }

    private static int addDigits(int n) {
        if (n == 0) return 0;
        return  n % 9 == 0 ? 9 : n % 9;
    }

    // recursive - NOT RECOMMENDED
    private static int addDigits2(int n) {
        while (n > 9) {
            n = add(n);
        }
        return n;
    }

    private static int add(int a) {
        int temp = 0;
        char[] carr = String.valueOf(a).toCharArray();

        for (char c : carr) temp += (c - '0');
        return temp;
    }
}
