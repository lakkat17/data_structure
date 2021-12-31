package linkedList;

public class ReverseLL{

    public static void main(String[] args) {
        LinkedList<Integer> ll = new SinglyLinkedList<>();
        ll.add(1);
        ll.add(2);
        ll.add(5);
        ll.add(7);
        System.out.println(ll);
        ll.reverse();
        System.out.println("Reversed LinkedList: " +ll);
        ll.reverseUsingLinks();
        System.out.println("Reversed LinkedList: " +ll);
    }
}
