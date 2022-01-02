package linkedList;

import java.util.Stack;

public class SinglyLinkedList<E> implements LinkedList<E> {

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

    public <E> SinglyLinkedList() {
    }

    @Override
    public void add(E e) {
        Node new_node = new Node(e);

        if (head == null) {
            head = new_node;
            tail = new_node;
        } else {
            tail.next = new_node;
            tail = new_node;
        }
    }

    @Override
    public <T extends LinkedList> void concat(T t) {
        Node p = head;

        while (p.next != null) {
            p = p.next;
        }
        p.next = ((SinglyLinkedList) t).head;
    }

    //pass head as parameter here
    public void displayInReverse(Node n) {
        if (n != null) {
            displayInReverse(n.next);
            System.out.print(n.e + " ");
        }
    }

    // call in case of integer values only
    // insert in ascending sorted LL
    public void insert(E e) {
        Node new_node = new Node(e);
        if (head == null) {
            head = new_node;
            tail = new_node;
        } else {
            Node p = head;
            Node q = null;
            while (p != null && (Integer) p.e < (Integer) e) {
                q = p;
                p = p.next;
            }
            if (q == null) {
                new_node.next = head;
                head = new_node;
            } else {
                q.next = new_node;
                new_node.next = p;

                if (q == tail)
                    tail = new_node;
            }
        }
    }

    // inserting node in LinkedList . Time Taken -> O(n)
    @Override
    public void insert(E e, int index) {
        int i = 0;
        Node new_node = new Node(e);
        if (index == 0) {
            new_node.next = head;
            head = new_node;
        } else if (index > 0 && index <= this.size()) {
            Node curr = head;
            while (i < index - 1) {  // used to move the pointer to required position in LL
                curr = curr.next;
                i++;
            }

            if (curr == tail)
                tail = new_node;

            new_node.next = curr.next;  // insert node to required position
            curr.next = new_node;
        } else
            System.out.println("Invalid index... Please select index range from 0 to " + (this.size()));
    }

    // only in case of integer values
    public boolean isSorted() {
        if (head != null) {
            int x = -2147483648;  // min int range 32 bits(4 bytes)
            Node p = head;
            while (p != null) {
                if (x > (Integer) p.e)
                    return false;
                x = (Integer) p.e;
                p = p.next;
            }
            return true;
        } else
            return true;
    }

    public int max() {
        if (head.e instanceof Integer) {
            int max = (Integer) head.e;
            Node n = head;
            while (n != null) {
                if (max < (Integer) n.e)
                    max = (Integer) n.e;
                n = n.next;
            }
            return max;
        }
        return 0;
    }

    // recursion
    public int max(Node n, int max) {
        if (n.e instanceof Integer) {
            if (n == null)
                return max;
            return max < (Integer) n.e ? max(n.next, (Integer) n.e) : max(n.next, max);
        }
        return 0;
    }

    // used for sorted lists
    //Consider lists of Integer
    public void merge(SinglyLinkedList ll) {
        Node p = head;
        Node q = ll.head;
        Node first = null;
        Node last = null;

        if ((Integer) p.e <= (Integer) q.e) {
            first = p;
            last = p;
            p = p.next;
            last.next = null;
        } else {
            first = q;
            last = q;
            q = q.next;
            last.next = null;
        }

        while (p != null && q != null) {
            if ((Integer) p.e <= (Integer) q.e) {
                last.next = p;
                last = p;
                p = p.next;
                last.next = null;
            } else {
                last.next = q;
                last = q;
                q = q.next;
                last.next = null;
            }
        }
        if (p != null)
            last.next = p;

        if (q != null) {
            last.next = q;
        }
        head = first;
    }

    public void remove(int index) {
        if (head == null || index < 0 || index >= size())  // when LL is empty
            return;

        Node p = head;
        Node q = null;

        int i = 0;
        while (i < index) {
            q = p;
            p = p.next;
            i++;
        }

        if (p == tail)
            tail = q;

        if (p == head)
            head = head.next;
        else
            q.next = p.next;
    }

    @Override
    public void removeAll() {
        head = null;
        tail = null;
    }

    // only in case of integer values
    //remove duplicates from sorted LL
    public void removeDuplicate() {
        Node n = head.next;
        Node q = head;

        while (n != null) {
            if ((Integer) q.e == (Integer) n.e) {
                q.next = n.next;
                n = q.next;
            } else {
                q = n;
                n = n.next;
            }
        }
    }

    //reverse data values
    public void reverse() {    // O(n) + O(n) = O(n)
        Node p = head;
        Object[] obj = new Object[size()];
        int i = 0;
        while (p != null) {
            obj[i++] = p.e;
            p = p.next;
        }
        p = head;

        while (p != null) {
            p.e = obj[--i];
            p = p.next;
        }
    }

    //reverse links
    public void reverseUsingLinks() {
        Node p = head;
        Node q = null;
        Node r = null;

        while (p != null) {
            r = q;
            q = p;
            p = p.next;
            q.next = r;
        }
        head = q;
    }

    public boolean search(E e) {
        Node n = head;
        while (n != null) {
            if (e == n.e)
                return true;
            n = n.next;
        }
        return false;
    }

    // Linear search and "moving to head" . This is to improve linear search for next time.
    public boolean searchAndMove(E e) {
        Node n = head;
        Node q = null;
        while (n != null) {
            if (e == n.e) {
                if (q != null) {  // check if element found at very first place.
                    q.next = n.next;  // This will remove matching node from LL.
                    if (n == tail)   // in case element found at tail position.
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

        if (n.e instanceof Integer) {
            int sum = 0;
            while (n != null) {
                sum += (Integer) n.e;
                n = n.next;
            }
            return sum;
        }
        return 0;
    }

    @Override
    public String toString() {

        if (head == null)
            return "[]";
        else {
            String s = "[ ";
            Node curr = head;
            do {
                s += curr.e + ", ";
                curr = curr.next;
            } while (curr != null);
            return s.substring(0, s.length() - 2) + " ]";
        }
    }

    public void link(SinglyLinkedList linkThis, int atIndex){
        Node p = this.head;

        for(int i = 0;i<atIndex;++i)
            p=p.next;

        linkThis.tail.next=p;
    }

    public void findIntersection(SinglyLinkedList ll) {
        Node p = this.head;
        Node q = ll.head;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        while (p != null) {
            s1.push(p);
            p = p.next;
        }

        while (q != null) {
            s2.push(q);
            q = q.next;
        }
        Node s = null;
        while (s1.peek().e == s2.peek().e) {
            s = s1.pop();
            s2.pop();
        }
        System.out.println("Insertion at: " + s.e);
    }

    // O(n) time & space O(1)
    public boolean isPalindrome(){

        if(head==null && head.next==null)
            return false;

        Node mid=null,prev=null,curr=null, slow = head, fast=head;

        // getting mid of LL   -> O(n)
        while (fast != null) {
            fast = fast.next != null ? fast.next.next : null;
            mid = slow;
            slow = slow.next;
        }

        //reversing 2nd half   -> O(n/2)
        while(slow!=null){
            prev=curr;
            curr=slow;
            slow=slow.next;
            curr.next=prev;
        }
        //saving mid Node
        mid.next=curr;

        //comparing first and 2nd half of LL
        fast=head;
        mid=mid.next;

        while (mid!=null && fast.e==mid.e){   // O(n/2)
            mid=mid.next;
            fast=fast.next;
        }

        if(mid==null)
            return true;
        return false;
    }
}
