package goal.algorithms.lists;

public class RotateList {

    public static void main(String[] args) {

        MyLinkedList l1 = new MyLinkedList();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(6);
        int k = 4;
        k = k % l1.size();

        Node head = l1.getHead();
        Node tail = head;
        int count = l1.size();

        while (tail.getNext() != null) {
            tail = tail.getNext();
        }

        tail.setNext(head);

        for (int i = 0; i < count - k; i++) {
            tail = tail.getNext();
            head = head.getNext();
        }

        tail.setNext(null);

        while (head != null) {
            System.out.print((int) head.getData() + " ");
            head = head.getNext();
        }
    }

}
