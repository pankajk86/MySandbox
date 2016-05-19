package goal.algorithms.lists;

public class OddEvenLinkedList {

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        Node updated = groupOddEven(list);

        for (Node node = updated; node != null; node = node.getNext()) {
            System.out.println((Integer) node.getData());
        }
    }

    private static Node groupOddEven(MyLinkedList list) {

        Node result = list.getHead();
        Node p1 = list.getHead();
        Node p2 = list.getHead().getNext();
        Node connectNode = list.getHead().getNext();

        while (p1 != null && p2 != null) {

            Node temp = p2.getNext();
            if (temp == null) {
                break;
            }

            p1.setNext(p2.getNext());
            p1 = p1.getNext();

            p2.setNext(p1.getNext());
            p2 = p2.getNext();
        }

        p1.setNext(connectNode);

        return result;
    }

}
