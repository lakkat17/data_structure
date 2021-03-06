package linkedList;

public class CircularLinkedList<E> implements LinkedList<E>{

    Node head = null;
    Node tail = null;

    class Node<E> {
        E e;
        Node next;

        Node(E e) {
            this.e = e;
            next = null;
        }
    }

    @Override
    public void add(E e) {
        Node new_node = new Node(e);

        if (head == null) {
            head = new_node;
            new_node.next = head;
        } else {
            Node n = head;
            while (n.next != head)
                n = n.next;
            n.next = new_node;
            new_node.next = head;
        }
    }

    @Override
    public void insert(E e, int index) {
        Node new_node = new Node(e);
        Node n = head;

        if (head == null) {
            head = new_node;
            new_node.next=head;
        } else if (index == 0) {
            new_node.next=head;
            while(n.next!=head)
                n=n.next;
            n.next=new_node;
            head=new_node;
        }else{
            for(int i=0;i<index-1;++i)
                n=n.next;
            new_node.next=n.next;
            n.next=new_node;
        }

    }

    @Override
    public void insert(Object o) {

    }

    @Override
    public int size() {
        Node n=head;
        int size=0;
        if(head==null){}
        else{
            do{
                n=n.next;
                size++;
            }while(n!=head);
        }
        return size;
    }

    @Override
    public void remove(int index) {
        Node n = head;

        if (index >= 0 && index < size()) {
            if (head == null)
                return;

            if (index == 0) {
                while (n.next != head)
                    n = n.next;
                n.next = head.next;
                head = head.next;
            } else {
                for (int i = 0; i < index - 1; ++i)
                    n = n.next;
                n.next = n.next.next;
            }
        }else
            throw new RuntimeException("Invalid Index...");
    }

    @Override
    public void removeAll() {

    }

    @Override
    public void reverse() {

    }

    @Override
    public void reverseUsingLinks() {

    }

    @Override
    public boolean search(Object o) {
        return false;
    }

    @Override
    public void concat(LinkedList linkedList) {

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[ ");
        Node n = head;
        if (head != null) {
            do {
                sb.append(n.e + ", ");
                n = n.next;
            } while (n != head);
        }
        sb.append("]");
        return sb.toString().replace(", ]"," ]");
    }

    public static void main(String[] args) {
        CircularLinkedList ll = new CircularLinkedList();
        ll.add(10);
        ll.add(20);
        ll.add(40);
        System.out.println("Circular LinkedList " + ll);
        ll.insert(30,3);
        System.out.println("After inserting: " + ll);
        ll.remove(3);
        System.out.println("After deletion: " + ll);
    }
}
