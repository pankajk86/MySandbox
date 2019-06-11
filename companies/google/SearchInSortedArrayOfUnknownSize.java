package google;

public class SearchInSortedArrayOfUnknownSize {

	public static void main(String[] args) {
		int[] a = { -1, 0, 3, 5, 9, 12 };
		int target = 2;
		ArrayReader ar = new ArrayReader(a);
		
		int result = searchLinear(ar, target);
		System.out.println(result);
		
		result = searchLogn(ar, target);
		System.out.println(result);
	}

	private static int searchLogn(ArrayReader ar, int target) {
		int start = 0, end = findEnd(ar, target);
		while(start + 1 < end) {
			int mid = start + (end - start) / 2;
			if(target <= ar.get(mid))
				end = mid;
			else start = mid;
		}
		
		if(ar.get(start) == target) return start;
		else if(ar.get(end) == target) return end;
		return -1;
	}
	
	private static int findEnd(ArrayReader ar, int target) {
		int index = 1;
		while(true) {
			if(ar.get(index) >= target) return index;
			else index *= 2;
		}
	}

	private static int searchLinear(ArrayReader ar, int target) {
		for(int i = 0; ar.get(i) != Integer.MAX_VALUE; ) {
			if(ar.get(i) < target) i++;
			else if(ar.get(i) == target) return i;
			else return -1;
		}
		return -1;
	}

}

class ArrayReader {
	private int[] a;

	ArrayReader(int[] a) {
		this.a = a;
	}

	public int get(int i) {
		return this.a[i];
	}
}