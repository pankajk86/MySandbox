package goal.arithmetic;

public class CheckPalindromeNumber {

	public static void main(String[] args) {
		int num = 1234321;
		boolean result = checkPalindrome(num);
		System.out.println("Is " + num + " palindrome: " + result);
	}

	private static boolean checkPalindrome(int n) {
		int num = n;
		int reverse = 0;
		
		while(n > 0) {
			int dig = n%10;
			reverse = reverse*10 + dig;
			n = n/10;
		}
		
		if(reverse == num) {
			return true;
		}
		
		return false;
	}

}
