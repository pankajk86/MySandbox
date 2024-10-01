package goal.algorithms.lists;

import google.ListNode;

public class AddNumberLists {

    public static void main(String[] args) {
        ListNode l1 = createList1();
        ListNode l2 = createList2();

        ListNode result = add(l1, l2);
        System.out.println(result);
    }

    private static ListNode add(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int carry = 0;
        ListNode c1 = l1, c2 = l2, c = dummy;

        for (; c1 != null && c2 != null; c1 = c1.next, c2 = c2.next, c = c.next) {
            int sum = carry + c1.val + c2.val;
            carry = sum / 10;
            c.next = new ListNode(sum % 10);
        }

        for (; c1 != null; c1 = c1.next, c = c.next) {
            int sum = carry + c1.val;
            carry = sum / 10;
            c.next = new ListNode(sum % 10);
        }

        for (; c2 != null; c2 = c2.next, c = c.next) {
            int sum = carry + c2.val;
            carry = sum / 10;
            c.next = new ListNode(sum % 10);
        }

        if (carry > 0) c.next = new ListNode(carry);
        return dummy.next;
    }

    private static ListNode createList1() {
        ListNode n2 = new ListNode(2);
        ListNode n4 = new ListNode(4);
        ListNode n3 = new ListNode(3);

        n4.next = n3; n2.next = n4;
        return n2;
    }

    private static ListNode createList2() {
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n4 = new ListNode(4);

        n6.next = n4; n5.next = n6;
        return n5;
    }
}
