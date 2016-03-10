package goal.algorithms.lists;

public class FindMergingNodeInList {

	public static void main(String[] args) {
		MyLinkedList l1 = new MyLinkedList();
		MyLinkedList l2 = new MyLinkedList();
		
		l1.add(2);l1.add(4);l1.add(3);l1.add(5);l1.add(7);
		l2.add(6);l2.add(11);l2.add(3);l2.add(5);l2.add(7);
		
		Node reverse1 = ReverseList.reverseList(l1);
		Node reverse2 = ReverseList.reverseList(l2);
		Node mergedNode = null;
		
		while((Integer) reverse1.getData() == (Integer) reverse2.getData()) {
			mergedNode = reverse1;
			reverse1 = reverse1.getNext();
			reverse2 = reverse2.getNext();
		}
		
		System.out.println(mergedNode.getData());
	}

}
