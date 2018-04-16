package goal9498.array;

import java.util.HashSet;
import java.util.Set;

public class TestTrash {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		Set<Integer> bag = new HashSet<>();
		
		for(int i: a) {
			bag.add(i);
		}
		
		System.out.println(bag.contains(a[2]));
	}

}
