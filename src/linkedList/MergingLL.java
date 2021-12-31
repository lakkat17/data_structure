package linkedList;

public class MergingLL {

    public static void main(String[] args) {
        SinglyLinkedList ll1 = new SinglyLinkedList();
        ll1.add(1);
        ll1.add(4);
        ll1.add(7);
        SinglyLinkedList ll2 = new SinglyLinkedList();
        ll2.add(2);
        ll2.add(5);
        ll2.add(9);
        ll1.merge(ll2);
        System.out.println(ll1);
    }

}
