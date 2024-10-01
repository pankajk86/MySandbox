package goal.algorithms.lists;

import google.ListNode;

public class ReverseList {

    public static void main(String[] args) {
        ListNode head = createList();
        ListNode result = reverseList(head);
        System.out.println(result);

    }

    private static ListNode createList() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n4.next = n5; n3.next = n4; n2.next = n3; n1.next = n2;
        return n1;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode curr = head;
            head = curr.next;
            curr.next = prev;
            prev = curr;
        }

        return prev;
    }

}
