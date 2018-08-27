package arrays;

public class CheckPrimeNumber {

	public static void main(String[] args) {
		int n = 14;
		boolean flag = true;
		
		for(int i = 2; i <= n / 2; i++) {
			if(n % i == 0) {
				flag = false;
				break;
			}
		}
		
		System.out.println(flag);
	}

}
