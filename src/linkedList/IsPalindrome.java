package linkedList;

public class IsPalindrome {

    public static void main(String[] args) {
        SinglyLinkedList ll = new SinglyLinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(2);
        ll.add(1);
        if(ll.isPalindrome())
            System.out.println("Linked List is a palindrome");
        else
            System.out.println("Linked List is not a palindrome");
    }

}
