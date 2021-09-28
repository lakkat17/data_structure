package recursion;

public class sumInArray {

    private static int add(int[] A, int n) {
        if (n < 0)
            return 0;
        else
            return add(A, n - 1) + A[n];
    }

    public static void main(String[] args) {
        int A[] = {2, 4, 9, 5, 1, 12, 15, 20};
        int sum = add(A, A.length - 1);
        System.out.println("Sum of elements in an array is: " + sum);
    }

}
