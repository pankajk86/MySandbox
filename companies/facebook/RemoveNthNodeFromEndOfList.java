package facebook;

import google.ListNode;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode head = createList();
        int n = 2;

        ListNode result = remove(head, n);
        System.out.println(result);
    }

    private static ListNode remove(ListNode head, int n) {
        ListNode fast = head, slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            head = head.next;
            return head;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
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
