package arrays;

public class InsertInSortedArray {

    private static int[] insert(int[] A, int len, int x) {
        int i = len - 1;
        while (A[i] > x) {
            A[i + 1] = A[i];
            i--;
        }
        A[i + 1] = x;
        return A;
    }

    private static void display(int[] A) {
        for (int i : A) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 5, 8, 9, 12, 20, 34, 45, 0, 0};
        int len = 9;
        int x = 10;
        display(insert(A, len, x));
    }
}
