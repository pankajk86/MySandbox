package goal.algorithms.lists;

public class MyLinkedListTest {

	public static void main(String[] args) {
		
		MyLinkedList list = new MyLinkedList();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println(list.get(5));
		
		list.remove(1);
		list.remove(2);
		list.remove(3);
		list.remove(4);
		list.remove(-5);
		
		System.out.println(list.size());
	}

}
