package facebook;

import google.ListNode;

import java.util.Stack;

public class RemoveNodesFromLinkedList {

    public static void main(String[] args) {
        ListNode head = createList();
        ListNode result = removeNodesLinearSpace(head);
        System.out.println(result);

        result = removeNodesConstantSpace(head);
        System.out.println(result);
    }

    private static ListNode removeNodesConstantSpace(ListNode head) {
        head = reverse(head);
        ListNode curr = head;
        int max = curr.val;

        // 8, 3, 13, 2, 5

        while (curr.next != null) {
            if (curr.next.val < max) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
                max = curr.val;
            }
        }

        return reverse(head);
    }

    private static ListNode reverse(ListNode head) {
        // 1 2 3
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }


    private static ListNode removeNodesLinearSpace(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (stack.isEmpty()) stack.push(cur);
            else {
                while (!stack.isEmpty() && stack.peek().val < cur.val) {
                    stack.pop();
                }
                stack.push(cur);
            }
        }

        ListNode newHead = null;
        while (!stack.isEmpty()) {
            ListNode cur = stack.pop();
            if (newHead != null) {
                cur.next = newHead;
            }
            newHead = cur;
        }
        return newHead;
    }

    private static ListNode createList() {
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(13);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(8);

        n4.next = n5; n3.next = n4; n2.next = n3; n1.next = n2;
        return n1;
    }
}
