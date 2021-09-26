package arrays;

public class OperationsOnArray {

    private static int arr[] = new int[10], len = 0;

    //traversing
    private static void display() {
        int strt = 0;
        while (strt < len) {
            System.out.print(arr[strt] + " ");
            strt++;
        }
    }

    //appending
    private static void add(int ele) {
        arr[len++] = ele;
        System.out.println("Element added: " + ele);
    }

    // inserting an element
    private static void insert(int ele, int index) {
        int strt = len;
        while (strt > index) {
            arr[strt] = arr[--strt];
        }
        arr[index] = ele;
        len++;
        System.out.println("\nInserted: " + ele + " at index: " + index);
    }

    // deleting an element
    private static void delete(int index) {
        int strt = index;
        while (strt < len) {
            arr[strt] = arr[++strt];
        }
        len--;
        System.out.println("\nDeleted an element from index: " + index);
    }

    // Finding largest
    private static void max() {
        int max = arr[0], strt = 1;
        while (strt < len) {
            if (max < arr[strt])
                max = arr[strt];
            strt++;
        }
        System.out.print("\nLargest element in the array is: " + max);
    }

    //reversing array
    private static void reverse() {
        for (int i = 0, j = len - 1; i < j; ++i, --j) {
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
        }
        System.out.println("\nArray has been reversed: ");
    }

    // Finding smallest
    private static void min() {
        int min = arr[0], strt = 1;
        while (strt < len) {
            if (min > arr[strt])
                min = arr[strt];
            strt++;
        }
        System.out.print("\nSmallest element in the array is: " + min);
    }

    //searching an element
    private static void search(int ele) {
        int strt = 0;
        while (strt < len) {
            if (arr[strt++] == ele) {
                System.out.print("\nElement " + ele + " found at position: " + strt);
                return;
            }
        }
        System.out.print("\nElement " + ele + " not found");
    }

    public static void main(String[] args) {
        add(5);
        add(2);
        add(10);
        display();
        insert(3, 1);
        display();
        insert(7, 3);
        display();
        delete(2);
        display();
        max();
        min();
        reverse();
        display();
        search(5);
        search(8);
    }
}