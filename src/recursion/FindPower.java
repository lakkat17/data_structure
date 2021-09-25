package recursion;

public class FindPower {

    private static long pow1(int n, int m) {
        if (m == 0)
            return 1;
        else
            return pow1(n, m - 1) * n;
    }

    private static long pow2(int n, int m) {
        if (m == 0)
            return 1;
        else if (m % 2 == 0)
            return pow2(n * n, m / 2);
        else
            return n * pow2(n * n, (m - 1) / 2);
    }

    public static void main(String[] args) {
        int num = 2, pow = 4;

        System.out.println(pow2(num, pow));
    }

}
