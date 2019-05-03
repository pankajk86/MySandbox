package amazon;

public class DesignRLEIterator {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
	}

	private static void test1() {
		int[] a = { 3, 8, 0, 9, 2, 5 };
		
		RLEIterator rle = new RLEIterator(a);
		System.out.print(rle.next(2) + " ");
		System.out.print(rle.next(1) + " ");
		System.out.print(rle.next(1) + " ");
		System.out.println(rle.next(2) + " ");
	}
	
	private static void test2() {
		int[] a = { 10, 4, 20, 9, 2, 10, 4, 7 };
		
		RLEIterator rle = new RLEIterator(a);
		System.out.print(rle.next(12) + " ");
		System.out.print(rle.next(5) + " ");
		System.out.print(rle.next(14) + " ");
		System.out.println(rle.next(5) + " ");
	}
	
	private static void test3() {
		int[] a = { 923381016, 843, 898173122, 924, 540599925, 391, 705283400, 275, 811628709, 850, 895038968, 590,
				949764874, 580, 450563107, 660, 996257840, 917, 793325084, 82 };
		
		RLEIterator rle = new RLEIterator(a);
		System.out.print(rle.next(612783106) + " ");
		System.out.print(rle.next(486444202) + " ");
		System.out.print(rle.next(630147341) + " ");
		System.out.print(rle.next(845077576) + " ");
		System.out.print(rle.next(243035623) + " ");
		System.out.print(rle.next(731489221) + " ");
		System.out.print(rle.next(117134294) + " ");
		System.out.println(rle.next(220460537) + " ");		
	}
	
	private static void test4() {
		int[] a = { 635, 606, 576, 391, 370, 981, 36, 21, 961, 185, 124, 210, 801, 937, 22, 426, 101, 260, 221, 647,
				350, 180, 504, 39, 101, 989, 199, 358, 732, 839, 919, 169, 673, 967, 58, 676, 846, 342, 250, 597, 442,
				174, 472, 410, 569, 509, 311, 357, 838, 251 };
		
		RLEIterator rle = new RLEIterator(a);
		System.out.print(rle.next(5039) + " ");
		System.out.print(rle.next(62) + " ");
		System.out.print(rle.next(3640) + " ");
		System.out.print(rle.next(671) + " ");
		
		System.out.print(rle.next(67) + " ");
		System.out.print(rle.next(395) + " ");
		System.out.print(rle.next(262) + " ");
		System.out.print(rle.next(839) + " ");
		
		System.out.print(rle.next(74) + " ");
		System.out.print(rle.next(43) + " ");
		System.out.print(rle.next(42) + " ");
		System.out.print(rle.next(77) + " ");
		
		System.out.print(rle.next(13) + " ");
		System.out.print(rle.next(6) + " ");
		System.out.print(rle.next(3) + " ");
		
		for(int i = 0; i < 35; i++) {
			if(i == 34) System.out.println(rle.next(1) + " ");
			else System.out.print(rle.next(1) + " ");
		}
	}

}


class RLEIterator {
	
	private int[] a = null;
	private int index = 0;
	
	public RLEIterator(int[] input) {
		a = input;
    }
    
    public int next(int n) {
    	if(index >= a.length)
    		return -1;
    	
    	if(a[index] < n) {
    		while(n > a[index]) {
    			n -= a[index];
    			index += 2;
    			
    			if(index >= a.length)
    				return -1;
    		}
    	}
    	
    	int result = a[index + 1];
    	a[index] -= n;
    	
    	while(a[index] <= 0) {
    		index += 2;
    		
    		if(index >= a.length)
				break;
    	}
    	
    	return result;
    }
}
