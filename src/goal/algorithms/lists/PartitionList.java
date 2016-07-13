package goal.algorithms.lists;

public class PartitionList {

    public static void main(String[] args) {
        Node head = createList();
        Node newHead = partitionList(head, 5);

        Node current = newHead;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    private static Node partitionList(Node head, int data) {

        Node current = head;
        Node end = null;
        Node newHead = null;

        while (current != null) {
            end = current;
            current = current.next;
        }

        current = head;

        if (end != null) {
            while (current != null) {
                if (current.data == data) {
                    break;
                }

                Node next = current.next;
                if (current.data > data) {
                    current.next = null;
                    end.next = current;
                    end = end.next;
                }
                current = next;
            }

            newHead = current.next;
            Node temp = newHead;
            Node previous = current;

            while (temp.data < data) {
                temp = temp.next;
                previous = previous.next;
            }

            // prev = 1, temp = 7
            current.next = previous.next;
            previous.next = current;
        }

        return newHead;
    }

    private static Node createList() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);

        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = node10;
        node10.next = node5;
        node5.next = node4;
        node4.next = node2;
        node2.next = node3;
        node3.next = node1;

        return node6;
    }

    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

}
