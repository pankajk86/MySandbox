package facebook;

import google.ListNode;

public class PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = createList();
        boolean result = isPalindrome(head);
        System.out.println(result);
    }

    private static boolean isPalindrome(ListNode head) {
        int[] a = new int[100000];
        int index = 0;

        for (ListNode curr = head; curr != null; curr = curr.next) {
            a[index++] = curr.val;
        }

        for (int i = 0, j = index - 1; i <= j; i++, j--) {
            if (a[i] != a[j]) return false;
        }
        return true;
    }

    private static ListNode createList() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);

        n3.next = n4; n2.next = n3; n1.next = n2;
        return n1;
    }
}
