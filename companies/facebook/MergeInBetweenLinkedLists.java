package facebook;

import google.ListNode;

public class MergeInBetweenLinkedLists {

    public static void main(String[] args) {
        ListNode l1 = createList1();
        ListNode l2 = createList2();
        int a = 3, b = 4;

        ListNode result = mergeInBetween(l1, a, b, l2);
        System.out.println(result);
    }

    private static ListNode mergeInBetween(ListNode l1, int a, int b, ListNode l2) {
        ListNode prev = null, next = null, curr = l1;
        int index = 0;

        while (curr != null && index < a) {
            prev = curr;
            curr = curr.next;
            index++;
        }

        while (curr != null && index <= b) {
            curr = curr.next;
            next = curr;
            index++;
        }

        ListNode l2Tail = l2;
        while (l2Tail.next != null) l2Tail = l2Tail.next;

        prev.next = l2;
        l2Tail.next = next;
        return l1;
    }

    private static ListNode createList1() {
        ListNode n1 = new ListNode(10);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(13);
        ListNode n4 = new ListNode(6);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(5);

        n5.next = n6; n4.next = n5; n3.next = n4; n2.next = n3; n1.next = n2;
        return n1;
    }

    private static ListNode createList2() {
        ListNode n1 = new ListNode(1000000);
        ListNode n2 = new ListNode(1000001);
        ListNode n3 = new ListNode(1000002);

        n2.next = n3; n1.next = n2;
        return n1;
    }


}
