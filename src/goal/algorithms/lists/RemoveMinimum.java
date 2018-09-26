package goal.algorithms.lists;

public class RemoveMinimum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        MyLinkedList list = new MyLinkedList();
        list.add(2);
        list.add(5);
        list.add(1);
        list.add(6);

        removeMinimum(list);
    }

    private static void removeMinimum(MyLinkedList list) {
        // TODO Auto-generated method stub

        Node node = list.getHead();

        Node min = node;

        while (node != null) {
            if (Integer.parseInt(node.getData().toString()) < Integer.parseInt(min.getData().toString())) {
                min = node;
            }
            node = node.getNext();
        }

        System.out.println(node != null ? node.getData().toString() : "");

    }

}
