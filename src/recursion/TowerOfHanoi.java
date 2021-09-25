package recursion;

public class TowerOfHanoi {

    private static void TOI(int n, int A, int B, int C) {
        if (n > 0) {
            TOI(n - 1, A, C, B);
            System.out.println(A + " to " + C);
            TOI(n - 1, B, A, C);
        }
    }

    public static void main(String[] args) {
        int disks = 3;
        TOI(disks, 1, 2, 3);
    }

}
