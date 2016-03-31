package goal.algorithms.lists;

public class ReverseList {

    public static void main(String args[]) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Node current = reverseList(list);

        while (current != null) {
            System.out.println((Integer) current.getData());
            current = current.getNext();
        }

    }

    public static Node reverseList(MyLinkedList list) {

        Node head = list.getHead();
        Node currentNode = head, previousNode = null;

        while (currentNode != null) {
            Node nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }

}
