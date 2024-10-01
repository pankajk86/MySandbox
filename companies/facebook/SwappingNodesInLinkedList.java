package facebook;

import google.ListNode;

public class SwappingNodesInLinkedList {

    public static void main(String[] args) {
        ListNode head = createList();
        int k = 2;

        ListNode result = swapNodes(head, k);
        System.out.println(result);
    }

    private static ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        for (int i = 1; i < k; i++) curr = curr.next;

        ListNode a = curr, b = head;
        while (curr != null && curr.next != null) {
            curr = curr.next;
            b = b.next;
        }

        int temp = a.val;
        a.val = b.val;
        b.val = temp;

        return head;
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
}
