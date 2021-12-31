package linkedList;

import java.util.HashSet;
import java.util.Set;

public class CheckLoopInLL {

    Node head = null;
    Node tail = null;

    class Node {
        int e;
        Node next;

        Node(int e) {
            this.e = e;
            next = null;
        }
    }

    private void createLoop(int index) {
        Node n = head;
        while(n.next!=null){
            n=n.next;
        }
        int i=0;
        Node p = head;
        while(i<index){
            p=p.next;
            i++;
        }
        n.next=p;
    }

    public boolean isLoop() {
        Node p = head;
        Node q = head;

        do {
            p = p.next;
            q = q.next;
            q = q.next != null ? q.next : null;
        } while (p != null && q != null && p != q);

        return p == q ? true : false;
    }

    public void add(int e) {
        Node new_node = new Node(e);

        if (head == null) {
            head = new_node;
            tail = new_node;
        } else {
            tail.next = new_node;
            tail = new_node;
        }
    }

    public String toString() {

        if (head == null)
            return "[]";
        else {
            int len = size();
            String s = "[ ";
            Node curr = head;
            do {
                s += curr.e + ", ";
                curr = curr.next;
                len--;
            } while (len>0);
            return s.substring(0, s.length() - 2) + " ]";
        }
    }

    public int size(){
        int size = 0 ;
        Node p = head;
        while(p!=tail){
            size++;
            p=p.next;
        }
        return ++size;
    }

    public static void main(String[] args) {

        CheckLoopInLL ll = new CheckLoopInLL();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.add(40);
        ll.add(50);

        ll.createLoop(2);

        System.out.println(ll);
        System.out.println("List linked " + ll + " contains loop: " +  ll.isLoop());


    }
}
