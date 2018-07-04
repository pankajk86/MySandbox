package arrays;

public class DuplicateNumber {

	public static void main(String[] args) {
		int[] a = { 1, 3, 4, 2, 2 };
		int result = findDupicate(a);
		System.out.println(result);
	}

	private static int findDupicate(int[] a) {
		
		int slow = 0, fast = 0;
		
		while(true) {
			fast = a[a[fast]];
			slow = a[slow];
			
			if(slow == fast) {
				break;
			}
		}
		
		fast = 0;
		
		while(slow != fast) {
			fast = a[fast];
			slow = a[slow];
		}
		
		return fast;
	}

}
