package linkedList;

public class LinkedList {
    Node head = null;
    Node tail = null;

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    void add(int data) {
        Node new_node = new Node(data);

        if (head == null) {
            head = new_node;
            tail = new_node;
        } else {
            tail.next = new_node;
            tail = new_node;
        }
    }

    @Override
    public String toString() {

        if (head == null)
            return "[]";
        else {
            String s = "[ ";
            Node curr = head;
            do {
                s += curr.data + ", ";
                curr = curr.next;
            } while (curr != null);
            return s.substring(0, s.length() - 2) + " ]";
        }
    }

    public void displayInReverse(Node n) {
        if (n != null) {
            displayInReverse(n.next);
            System.out.print(n.data + " ");
        }
    }

    // Time taken -> O(n)
    public int size() {
        Node n = head;
        int size = 0;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
    }

    //recursion
    // Time taken -> O(n), Space -> O(n) due to recursive call.
    public int size(Node n) {
        if (n == null)
            return 0;
        else
            return size(n.next) + 1;
    }

    public int sum() {
        Node n = head;
        int sum = 0;
        while (n != null) {
            sum += n.data;
            n = n.next;
        }
        return sum;
    }

    public int max() {
        int max = head.data;
        Node n = head;
        while (n != null) {
            if (max < n.data)
                max = n.data;
            n = n.next;
        }
        return max;
    }

    // recursion
    public int max(Node n, int max) {
        if (n == null)
            return max;
        return max < n.data ? max(n.next, n.data) : max(n.next, max);
    }

    // Linear search
    public boolean search(int ele) {
        Node n = head;
        while (n != null) {
            if (ele == n.data)
                return true;
            n = n.next;
        }
        return false;
    }

    // Linear search and "moving to head" . This is to improve linear search for next time.
    public boolean searchAndMove(int ele) {
        Node n = head;
        Node q = null;
        while (n != null) {
            if (ele == n.data) {
                if (q != null) {  // check if element found at very first place.
                    q.next = n.next;  // This will remove matching node from LL.
                    if(n==tail)   // in case element found at tail position.
                        tail = q;
                    n.next = head;    // This will move matching
                    head = n;         // node to head.
                    return true;
                }
            }
            q = n;
            n = n.next;
        }
        return false;
    }

    // inserting node in LinkedList . Time Taken -> O(n)
    public void insert(int data, int index) {
        int i = 0;
        Node new_node = new Node(data);
        if (index == 0) {
            new_node.next = head;
            head = new_node;
        } else if (index > 0 && index <= this.size()) {
            Node curr = head;
            while (i < index - 1) {  // used to move the pointer to required position in LL
                curr = curr.next;
                i++;
            }

            if(curr == tail)
                tail=new_node;

            new_node.next = curr.next;  // insert node to required position
            curr.next = new_node;
        } else
            System.out.println("Invalid index... Please select index range from 0 to " + (this.size()));
    }

    public static void main(String[] args) {
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
    }
}
