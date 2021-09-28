package arrays;

/*
shifting negatives on left and
 positive integers on right side in an array
 */
public class ShiftNegPos {

    private static void shift(int[] A) {
        int i = 0, j = A.length - 1;

        while (i < j) {
            while (A[i] < 0)
                ++i;
            while (A[j] >= 0)
                --j;

            // swapping
            if (i < j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        // printing the array
        for (int e : A) {
            System.out.print(e + " ");
        }
    }

    public static void main(String[] args) {
        int[] A = {1, -2, 3, -4, 5, 6, -7, 8, -9};
        shift(A);
    }
}
