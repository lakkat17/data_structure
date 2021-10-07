package arrays;

public class SetOperationsOnArray {

    // All from A & B but common only 1 time.
    private static void union(int[] A, int[] B, int[] C) {
        int i = 0, j = 0, k = 0;
        int m = A.length, n = B.length;

        while (i < m && j < n) {
            if (A[i] < B[j])
                C[k++] = A[i++];
            else if (B[j] < A[i])
                C[k++] = B[j++];
            else {
                C[k++] = A[i++];
                j++;
            }
        }

        for (; i < m; ++i)
            C[k++] = A[i];

        for (; j < n; ++j)
            C[k++] = B[j];

        for (int e : C) {
            System.out.print(e + " ");
        }

    }

    // common in A & B
    private static void intersection(int[] A, int[] B, int[] C) {
        int i = 0, j = 0, k = 0;
        int m = A.length, n = B.length;

        while (i < m && j < n) {
            if (A[i] < B[j])
                i++;
            else if (B[j] < A[i])
                j++;
            else {
                C[k++] = A[i++];
                j++;
            }
        }

        for (int e : C) {
            System.out.print(e + " ");
        }

    }

    // A minus B (means non-common elements from A)
    private static void difference(int[] A, int[] B, int[] C) {
        int i = 0, j = 0, k = 0;
        int m = A.length, n = B.length;

        while (i < m && j < n) {
            if (A[i] < B[j])
                C[k++] = A[i++];
            else if (B[j] < A[i])
                j++;
            else {
                i++;
                j++;
            }
        }

        for (; i < m; ++i)
            C[k++] = A[i];

        for (int e : C) {
            System.out.print(e + " ");
        }

    }

    public static void main(String[] args) {
        //sorted arrays because unsorted one takes O(mXn) = O(n*n) time.

        int[] A = {2, 4, 6, 9, 10};
        int[] B = {3, 4, 6, 7, 9};
        int[] C = new int[10];
        int[] D = new int[5];
        int[] E = new int[10];

        union(A, B, C);   // Time taken -> O(m+n)
        System.out.println();
        intersection(A, B, D); // Time taken -> O(m+n)
        System.out.println();
        difference(A, B, E);   // Time taken -> O(m+n)
    }
}
