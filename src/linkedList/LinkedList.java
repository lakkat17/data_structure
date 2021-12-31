package linkedList;

interface LinkedList<E> {

    void add(E e);

    void insert(E e, int index);

    void insert(E e);

    int size();

    void remove(int index);

    void removeAll();

    void reverse();

    void reverseUsingLinks();

    <T extends LinkedList> void concat(T t);

    // Linear search
    boolean search(E e);

  /*  public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.add(10);
        ll.add(20);
        ll.add(40);
        ll.add(30);

        System.out.println(ll);
        ll.displayInReverse(ll.head);
        System.out.println("\nSize of LinkedList is: " + ll.size());
        System.out.println("Size of LinkedList using recursion is: " + ll.size(ll.head));
        System.out.println("Sum of all elements is: " + ll.sum());
        System.out.println("Maximum element in LinkedList is: " + ll.max());
        System.out.println("Maximum element in LinkedList using recursion is: " + ll.max(ll.head, ll.head.data));
        System.out.println("Element " + 30 + " found: " + ll.search(30));
        System.out.println("Element " + 30 + " found: " + ll.searchAndMove(30));
        System.out.println(ll);
        System.out.println("Inserting 50 at first position");
        ll.insert(50, 0);
        System.out.println(ll);
        System.out.println("Inserting 70 at fifth position");
        ll.insert(70, 5);
        System.out.println(ll);
        System.out.println("------------------------------------------------------------------------------------");
        LinkedList ll2 = new LinkedList();

        ll2.insert(10);
        ll2.insert(50);
        ll2.insert(20);
        ll2.insert(15);
        ll2.add(5);
        System.out.println(ll2);
        ll2.remove(3);
        ll2.remove(0);
        System.out.println(ll2);
        System.out.println("LinkedList is sorted: " + ll2.isSorted());
        LinkedList ll3 = new LinkedList();
        ll3.add(1);
        ll3.add(2);
        ll3.add(2);
        ll3.add(2);
        ll3.add(5);
        ll3.add(5);
        ll3.add(6);
        System.out.println(ll3);
        ll3.removeDuplicate();
        System.out.println("After removing duplicates: " + ll3);
        System.out.println("------------------------------------------------------------------------------------");

        System.out.println("------------------------------------------------------------------------------------");
        LinkedList ll5 = new LinkedList();
        ll5.add(10);
        ll5.add(20);
        ll5.add(30);
        ll5.add(40);
        ll4.concat(ll5);
        System.out.println("Concatenate ll4 + ll5 : " + ll4);
    }*/
}
