package goal.arrays;

public class CheckPalindromeNumber {

    public static void main(String[] args) {
        int num = 1234321;
        boolean result = checkPalindrome(num);
        System.out.println("Is " + num + " palindrome: " + result);
        
        result = isPalindrome(num);
        System.out.println(result);
    }

    private static boolean checkPalindrome(int n) {
        int num = n;
        int reverse = 0;

        while (n > 0) {
            int dig = n % 10;
            reverse = reverse * 10 + dig;
            n = n / 10;
        }

        if (reverse == num) {
            return true;
        }

        return false;
    }

    public static boolean isPalindrome(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
        	rev = rev*10 + x%10;
        	x = x/10;
        }
        return (x==rev || x==rev/10);
    }
}
