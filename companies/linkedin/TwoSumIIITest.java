package linkedin;

import java.util.HashMap;
import java.util.Map;

public class TwoSumIIITest {

	public static void main(String[] args) {
		MyTwoSumIII sum3 = new MyTwoSumIII();
		sum3.add(3);sum3.add(1);sum3.add(2);
		
		System.out.println(sum3.find(5));
	}

}

class MyTwoSumIII {
	
	private Map<Integer, Integer> map = new HashMap<>();
	
	public MyTwoSumIII() {
	}
	
	public void add(int n) {
		map.put(n, map.getOrDefault(n, 0) + 1);
	}
	
	public boolean find(int value) {
		for(Integer key: map.keySet()) {
			int left = value - key;
			if((left == key && map.get(key) > 1) || (left != key && map.containsKey(left)))
				return true;
		}
		
		return false;
	}
}

