package arrays;

public class FindMissingNumber {

    // First N natural numbers
    private static void findInNatural(int[] A, int m) {
        long sum = 0, s = 0;
        int n = A[m - 1];
        sum = n * (n + 1) / 2;
        for (int e : A) {
            s += e;
        }
        System.out.println("Missing number in first " + n + " natural numbers is: " + (sum - s));
    }

    // First N natural numbers starts with some number
    private static void findInNaturalStartsWith(int[] A, int n) {
        int start = A[0], i = 0;
        while (i < n) {
            if (A[i] - i != start) {
                System.out.println("Missing number is: " + (start + i) + " at index: " + i);
                break;
            }
            i++;
        }
        if (i == n)
            System.out.println("No number is missing in the array");
    }

    // missing multiple elements. time taken -> O(n)
    private static void findMultipleInNaturalStartsWith(int[] A, int n) {
        int diff = A[0], i = 0;
        while (i < n) {
            int check = A[i] - i;
            if (check != diff) {
                while (diff < check) {
                    System.out.println("Missing number is: " + (diff + i));
                    diff++;
                }
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        int[] B = {4, 5, 6, 7, 8, 9, 10, 12};
        int[] C = {4, 5, 7, 8, 9, 10, 13, 14, 15};
        findInNatural(A, A.length);
        findInNaturalStartsWith(B, B.length);
        findMultipleInNaturalStartsWith(C, C.length);
    }
}
