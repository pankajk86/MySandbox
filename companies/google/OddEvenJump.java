package google;

import java.util.TreeMap;

public class OddEvenJump {

	public static void main(String[] args) {
		int[] a = { 2, 3, 1, 1, 4 };
		int result = oddEvenJumps(a);
		System.out.println(result);
	}

	private static int oddEvenJumps(int[] a) {
		if(a == null || a.length == 0) return 0;
		
		int n = a.length, result = 0;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		boolean[] odd = new boolean[n], even = new boolean[n];
		
		map.put(a[n - 1], n - 1);
		odd[n - 1] = true; even[n - 1] = true;
		
		for(int i = n - 2; i >= 0; i--) {
			Integer oddKey = map.ceilingKey(a[i]);
			if(oddKey != null)
				odd[i] = even[map.get(oddKey)];
			
			Integer evenKey = map.floorKey(a[i]);
			if(evenKey != null)
				even[i] = odd[map.get(evenKey)];
			
			map.put(a[i], i);
		}
		
		for(boolean b: odd) result += b ? 1 : 0;
		
		return result;
	}

}
