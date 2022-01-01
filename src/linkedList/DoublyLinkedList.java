package linkedList;

public class DoublyLinkedList<E> implements LinkedList<E> {
    Node head;
    Node tail;

    class Node<E> {
        Node prev;
        Node next;
        E e;

        Node(E e) {
            this.e = e;
            prev = null;
            next = null;
        }
    }


    @Override
    public void add(E e) {
        Node new_node = new Node(e);

        if(head==null)
            head = new_node;
        else {
            Node p = head;

            while(p.next!=null)
                p=p.next;
            p.next=new_node;
            new_node.prev=p;
        }
    }

    @Override
    public void insert(E e, int index) {
        Node new_node = new Node(e);

        if (index >= 0 && index <= size()) {
            if (head == null) {
                head = new_node;
                return;
            }
            //insert at first position
            if (index == 0) {
                head.prev = new_node;
                new_node.next = head;
                head = new_node;
            } else {
                Node p = head;
                for (int i = 0; i < index - 1; ++i) {
                    p = p.next;
                }
                new_node.next = p.next;
                new_node.prev = p;
                // insert at last position
                if (p.next != null)
                    p.next.prev = new_node;
                p.next = new_node;
            }
        } else
            throw new RuntimeException("Invalid index " + index);
    }

    @Override
    public void insert(E e) {

    }

    @Override
    public int size() {
        int size = 0;

        if (head == null) {
        } else {
            Node p = head;
            while (p != null) {
                p = p.next;
                size++;
            }
        }
        return size;
    }

    @Override
    public void remove(int index) {
        int size = size();
        if (index >= 0 && index < size) {
            if (head == null)
                return;
            else {
                Node p = head;
                if (index == 0) {
                    if (size == 1)
                        head = null;
                    else {
                        head = p.next;
                        p.next.prev = null;
                        p.next = null;
                    }
                } else {
                    for (int i = 0; i < index - 1; ++i)
                        p = p.next;

                    Node q;
                    if (p.next.next != null) {
                        q = p.next.next;
                        q.prev = p;
                        p.next = q;
                    } else {         // delete last element
                        q = p.next;
                        q.prev = null;
                        p.next = null;
                    }
                }
            }
        } else
            throw new RuntimeException("Invalid index: " + index);
    }

    @Override
    public void removeAll() {

    }

    @Override
    public void reverse() {

        if (head != null) {
            Node p = head;
            while (p != null) {
                Node temp = p.next;
                p.next = p.prev;
                p.prev = temp;
                if (p.prev == null)
                    head = p;
                p = p.prev;
            }
        }
    }

    @Override
    public void reverseUsingLinks() {

    }

    @Override
    public <T extends LinkedList> void concat(T t) {

    }

    @Override
    public boolean search(E e) {
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");

        if (head == null)
            sb.append("]");
        else {
            Node p = head;
            while (p != null) {
                sb.append(p.e + ", ");
                p = p.next;
            }
            sb.append("]");
        }
        return sb.toString().replace(", ]", " ]");
    }

    public static void main(String[] args) {
        DoublyLinkedList ll = new DoublyLinkedList();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(50);
        System.out.println("Doubly Linked List: " + ll);
        ll.insert(40,0);
        System.out.println("Inserting Element: " + ll);
        ll.remove(0);
        System.out.println("Deleting Element: " + ll);
        ll.reverse();
        System.out.println(ll);

    }
}
