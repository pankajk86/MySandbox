package linkedin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KClosestElements {

	public static void main(String[] args) {
		int[] a = {1, 3, 5, 7, 9};
		int k = 4, x = 10;
		
		List<Integer> result = kClosestElements(a, k, x);
		System.out.println(result);
	}

	private static List<Integer> kClosestElements(int[] a, int k, int x) {
		List<Integer> result = new ArrayList<>();
		int n = a.length;
		
		if(a == null || n == 0) return result;
		
		if(x <= a[0]) {
			for(int i = 0; i < k; i++)
				result.add(a[i]);
			return result;
		} else if(x >= a[n - 1]) {
			for(int i = n - k; i < n; i++)
				result.add(a[i]);
			return result;
		}
		
		List<DistElement> elist = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			int elem = a[i], dist = Math.abs(x - elem);
			elist.add(new DistElement(elem, dist));
		}
		
		Collections.sort(elist, new Comparator<DistElement>() {
			@Override
			public int compare(DistElement e1, DistElement e2) {
				if(e1.dist < e2.dist) return -1;
				else if(e1.dist > e2.dist) return 1;
				else {
					if(e1.val < e2.val) return -1;
					else if(e1.val > e2.val) return 1;
					else return 0;
				}
			}
		});
		
		for(int i = 0; i < k; i++) {
			result.add(elist.get(i).val);
		}
		
		Collections.sort(result);
		return result;
	}

}

class DistElement {
	int val, dist;
	
	DistElement(int val, int dist) {
		this.val = val;
		this.dist = dist;
	}
}
