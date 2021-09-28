package arrays;

public class BinarySearch {

    private static int biSearch(int[] arr, int n, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == n)
                return mid;
            else if (n > arr[mid])
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String... args) {
        int arr[] = {2, 4, 5, 7, 9, 11, 13, 14, 17, 18, 21, 23, 26, 34, 39};
        int loc = biSearch(arr, 39, 0, arr.length - 1);
        if (loc == -1)
            System.out.print("Element not found");
        else
            System.out.print("Element found at " + (loc + 1) + " position");
    }

}
