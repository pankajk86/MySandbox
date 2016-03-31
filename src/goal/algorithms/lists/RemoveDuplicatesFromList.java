package goal.algorithms.lists;

public class RemoveDuplicatesFromList {

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(1);

        list.removeDuplicates();

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
