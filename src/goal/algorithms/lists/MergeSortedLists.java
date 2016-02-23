package goal.algorithms.lists;

public class MergeSortedLists {

	public static void main(String[] args) {
		MyLinkedList l1 = new MyLinkedList();
		MyLinkedList l2 = new MyLinkedList();
		
		l1.add(1);l1.add(3);l1.add(5);l1.add(7);
		l2.add(2);l2.add(4);l2.add(6);l2.add(8);l2.add(10);
		
		MyLinkedList mergedList = mergeSortedLists(l1, l2);
		
		for(int i=0; i<mergedList.size(); i++) {
			System.out.print(mergedList.get(i) + " "); 
		}
	}

	private static MyLinkedList mergeSortedLists(MyLinkedList l1, MyLinkedList l2) {
		
		MyLinkedList mergedList = new MyLinkedList();
		Node p1 = l1.getHead(), p2 = l2.getHead();
		
		while(p1 != null && p2 != null) {
			if((Integer) p1.getData() < (Integer) p2.getData()) {
				mergedList.add(p1.getData());
				p1 = p1.getNext();
			} else {
				mergedList.add(p2.getData());
				p2 = p2.getNext();
			}
		}
		
		if(p1 == null) {
			while(p2 != null) {
				mergedList.add(p2.getData());
				p2 = p2.getNext();
			}
		}
		
		if(p2 == null) {
			while(p1 != null) {
				mergedList.add(p1.getData());
				p1 = p1.getNext();
			}
		}
		
		return mergedList;
	}

}
