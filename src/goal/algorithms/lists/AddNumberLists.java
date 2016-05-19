package goal.algorithms.lists;

public class AddNumberLists {

    public static void main(String[] args) {

        MyLinkedList list1 = new MyLinkedList();

        list1.add(2);
        list1.add(4);
        list1.add(3);

        MyLinkedList list2 = new MyLinkedList();

        list2.add(5);
        list2.add(6);
        list2.add(9);
        list2.add(5);

        Node list = add(list1, list2);

        while (list != null) {
            System.out.println((Integer) list.getData());
            list = list.getNext();
        }
    }

    private static Node add(MyLinkedList l1, MyLinkedList l2) {

        MyLinkedList list = new MyLinkedList();
        Node p1 = l1.getHead(), p2 = l2.getHead();
        int carry = 0;

        while (p1 != null || p2 != null) {
            int sum = carry;

            if (p1 != null) {
                sum += (Integer) p1.getData();
                p1 = p1.getNext();
            }

            if (p2 != null) {
                sum += (Integer) p2.getData();
                p2 = p2.getNext();
            }

            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            list.add(sum);
        }

        if (carry == 1) {
            list.add(1);
        }

        return list.getHead();
    }

}
