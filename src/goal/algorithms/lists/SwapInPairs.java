package goal.algorithms.lists;

public class SwapInPairs {

    public static void main(String[] args) {

        MyLinkedList l1 = new MyLinkedList();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(6);

        Node head = swapListInPairs(l1.getHead());

        while (head != null) {
            System.out.print((Integer) head.getData() + " ");
            head = head.getNext();
        }
    }

    private static Node swapListInPairs(Node head) {

        Node current = head;

        while (current != null && current.getNext() != null) {
            Integer temp = (Integer) current.getData();
            current.setData(current.getNext().getData());
            current.getNext().setData(temp);
            current = current.getNext().getNext();
        }

        return head;
    }

}
