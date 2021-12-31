package arrays;

import java.util.HashMap;

public class FindDuplicates {

    //find duplicates in sorted array
    private static void findDuplicates(int[] A, int n) {
        int i = 0, lastDuplicate = A[0];
        while (i < n - 1) {
            if (A[i] == A[i + 1] && lastDuplicate != A[i]) {
                System.out.println("Duplicate Number is:" + A[i]);
                lastDuplicate = A[i];
            }
            i++;
        }
    }

    // count duplicates in sorted array
    private static void countDuplicates(int[] A, int n) {
        int i = 0;
        while (i < n - 1) {
            if (A[i] == A[i + 1]) {
                int j = i + 1;
                while (j < n && A[j] == A[i])
                    j++;
                System.out.println("Duplicate number is: " + A[i] + " with count: " + (j - i));
                i = j - 1;
            }
            i++;
        }
    }

    // find & count duplicates in unsorted array  Time taken -> O(n*n)
    // we can reduce the time to O(n) with using HashTable of size equal to the largest number in array A
    private static void findAndCount(int[] A, int n) {

        for (int i = 0; i < n - 1; ++i) {
            int count = 1;

            if (A[i] != -1)
                for (int j = i + 1; j < n; ++j) {
                    if (A[i] == A[j]) {
                        count++;
                        A[j] = -1;
                    }
                }
            if (count > 1)
                System.out.println("Duplicate Number is: " + A[i] + " with count: " + count);
        }
    }

    // find a pair with sum = k . Time taken -> O(n*n)
    private static void findPair(int[] A, int k) {
        int n = A.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (A[i] + A[j] == k) {
                    System.out.println("Pair of elements are: " + A[i] + " & " + A[j] + " with sum " + k);
                }
            }
        }
    }

    // find a pair with sum = k . Time taken -> O(n)
    private static void findPairWithHashing(int[] A, int k, int max) {
        int n = A.length;
        int[] H = new int[max + 1];
        for (int i = 0; i < n; ++i) {
            if (A[i] <= k && H[k - A[i]] != 0)
                System.out.println("Pair of elements are: " + A[i] + " & " + (k - A[i]) + " with sum " + k);
            H[A[i]]++;
        }
    }

    private static void findPairWithHashing(int[] A, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            if (hm.get(A[i]) != null) {
                System.out.println("Pair of elements are: " + A[i] + " & " + (k - A[i]) + " with sum " + k);
            }
            hm.put(k - A[i], i);
        }
    }

    // find a pair with sum = k in a sorted array. Time Taken -> O(n)
    private static void findPairInSorted(int[] A, int k) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] + A[j] > k)
                j--;
            else if (A[i] + A[j] < k)
                i++;
            else {
                System.out.println("Pair found are: " + A[i] + " & " + A[j] + " with sum " + k);
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 5, 5, 6, 7, 8, 8, 8, 9, 9, 11, 13};
        int[] B = {5, 3, 3, 7, 2, 9, 4, 17, 17, 17, 12, 20};
        int[] C = {6, 3, 8, 10, 16, 7, 5, 2, 9, 14};
        int[] D = {1, 3, 4, 5, 6, 8, 9, 10, 12, 14};
        findDuplicates(A, A.length);
        System.out.println("-----------------------------------------------------------------------------------");
        countDuplicates(A, A.length);
        System.out.println("-----------------------------------------------------------------------------------");
        findAndCount(B, B.length);
        System.out.println("-----------------------------------------------------------------------------------");
        findPair(C, 10);
        System.out.println("-----------------------------------------------------------------------------------");
        findPairWithHashing(C, 10, 16);
        System.out.println("-----------------------------------------------------------------------------------");
        findPairWithHashing(C,10);
        System.out.println("-----------------------------------------------------------------------------------");
        findPairInSorted(D, 10);
    }
}
