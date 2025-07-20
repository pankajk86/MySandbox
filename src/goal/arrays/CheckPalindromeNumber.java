package goal.arrays;

public class CheckPalindromeNumber {

    public static void main(String[] args) {
        int num = 1234321;
        boolean result = checkPalindrome(num);
        System.out.println("Is " + num + " palindrome: " + result);
        
        result = isPalindrome(num);
        System.out.println(result);
    }

    private static boolean checkPalindrome(int x) {
        if (x < 0) return false;
        if (x == 0) return true;

        int reverse = 0, original = x;

        while (x > 0) {
            int curr = x % 10;
            reverse = reverse * 10 + curr;
            x /= 10;
        }

        return reverse == original;
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
