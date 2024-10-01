package microsoft;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		RandomListNode head = createRandomList();
		RandomListNode result = deepCopyLinearSpace(head);
		System.out.println(result.val);

		result = deepCopyConstantSpace(head);
		System.out.println(result.val);
	}

	private static RandomListNode deepCopyLinearSpace(RandomListNode head) {
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode nHead = null, nCurr = null, curr = null;
        
        for(curr = head; curr != null; curr = curr.next) {
        	RandomListNode newNode = new RandomListNode(curr.val);
            if(nHead == null) {
                nHead = newNode; nCurr = newNode;
            } else {
                nCurr.next = newNode; nCurr = nCurr.next;
            }
            map.put(curr, nCurr);
        }
        
        for(curr = head, nCurr = nHead; curr != null; curr = curr.next, nCurr = nCurr.next)
            nCurr.random = map.get(curr.random);
        
        return nHead;
	}

	private static RandomListNode deepCopyConstantSpace(RandomListNode head) {
		RandomListNode temp = head;
		while(temp != null) {
			RandomListNode next = temp.next;
			RandomListNode clone = new RandomListNode(temp.val);
			temp.next = clone;
			clone.next = next;
			temp = next;
		}

		temp = head;
		while(temp != null) {
			if(temp.random != null) {
				temp.next.random = temp.random.next;
			}
			temp = temp.next.next;
		}

		RandomListNode cloneHead = new RandomListNode(0);
		RandomListNode tempHead = cloneHead;
		temp = head;

		while(temp != null) {
			RandomListNode next = temp.next.next;
			RandomListNode clone = temp.next;
			tempHead.next = clone;
			tempHead = clone;
			temp.next = next;
			temp = next;
		}
		return cloneHead.next;
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
	int val;
	RandomListNode next, random;

	public RandomListNode(int val) {
		this.val = val;
	}
}
