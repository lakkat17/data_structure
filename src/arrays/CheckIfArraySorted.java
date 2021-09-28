package arrays;

public class CheckIfArraySorted {

    private static boolean isSorted(int[] A) {
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i + 1])
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1};
        if (isSorted(A))
            System.out.println("Array is sorted");
        else
            System.out.println("Array is not sorted");
    }

}
