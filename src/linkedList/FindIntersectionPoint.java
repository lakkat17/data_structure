package linkedList;

public class FindIntersectionPoint {


    public static void main(String[] args) {
        SinglyLinkedList ll1 = new SinglyLinkedList();
        SinglyLinkedList ll2 = new SinglyLinkedList();
        ll1.add(10);
        ll1.add(20);
        ll1.add(30);
        ll1.add(40);
        ll1.add(50);
        ll1.add(60);
        ll1.add(70);
        ll2.add(5);
        ll2.add(15);
        ll2.add(25);
        ll1.link(ll2,3);
        System.out.println(ll1);
        System.out.println(ll2);

        ll1.findIntersection(ll2);

    }

}
