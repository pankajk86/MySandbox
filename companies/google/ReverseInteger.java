package google;

public class ReverseInteger {

    public static void main(String[] args) {
        int x = 123;
        int result = reverse(x);
        System.out.println(result);
    }

    private static int reverse(int x) {
        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        int result = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (result > max / 10 || (result == max / 10 && digit >= max % 10)) return 0;
            if (result < min / 10 || (result == min / 10 && digit <= min % 10)) return 0;

            result = (result * 10) + digit;
        }

        return result;
    }
}
