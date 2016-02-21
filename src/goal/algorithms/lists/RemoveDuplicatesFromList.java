package goal.algorithms.lists;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesFromList {

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.add(1);
		list.add(2);
		list.add(2);
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(1);
		
		list = removeDuplicates(list);
		
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

	private static MyLinkedList removeDuplicates(MyLinkedList list) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		MyLinkedList newList = new MyLinkedList();
		
		for(int i=0; i<list.size(); i++) {
			
			Integer element = (Integer) list.get(i);
			
			if(map.get(element) == null) {
				map.put(element, 1);
				newList.add(element);
			}
		}
		
		return newList;
	}

}
