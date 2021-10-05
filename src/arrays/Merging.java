package arrays;

public class Merging {

    private static int[] merge(int[] a, int[] b, int n, int m) {
        int[] c = new int[10];
        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];
        }

        for (; i < n; i++)
            c[k++] = a[i];

        for (; j < m; j++)
            c[k++] = b[j];

        return c;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 7};
        int[] b = {3, 5, 6, 8, 9, 10};

        int[] c = merge(a, b, a.length, b.length);
        System.out.print("Merged array: ");

        for (int i : c) {
            System.out.print(i + " ");
        }
    }
}
