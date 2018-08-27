package microsoft;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		RandomListNode head = createRandomList();
		RandomListNode result = deepCopy(head);
		System.out.println(result.label);
	}

	private static RandomListNode deepCopy(RandomListNode head) {

		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		
		RandomListNode currentNew = null, headNew = null, current = head;
		
		while(current != null) {
			if(currentNew == null) {
				currentNew = new RandomListNode(current.label);
				headNew = currentNew;
			} else {
				RandomListNode next = new RandomListNode(current.label);
				currentNew.next = next;
				currentNew = currentNew.next;
			}
			
			map.put(current, currentNew);
			current = current.next;
		}
		
		current = head; currentNew = headNew;
		
		while(current != null) {
			currentNew.random = map.get(current.random);
			current = current.next;
			currentNew = currentNew.next;
		}
		
		return headNew;
	}

	private static RandomListNode createRandomList() {
		
		RandomListNode n1 = new RandomListNode(1);
		RandomListNode n2 = new RandomListNode(2);
		RandomListNode n3 = new RandomListNode(3);
		RandomListNode n4 = new RandomListNode(4);
		RandomListNode n5 = new RandomListNode(5);
		RandomListNode n6 = new RandomListNode(6);
		RandomListNode n7 = new RandomListNode(7);
		
		n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5; n5.next = n6; n6.next = n7;
		n2.random = n4; n3.random = n1; n4.random = n7;
		
		return n1;
	}

}

class RandomListNode {
	int label;
	RandomListNode next, random;

	public RandomListNode(int label) {
		this.label = label;
	}
}
