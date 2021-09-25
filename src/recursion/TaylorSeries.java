package recursion;

public class TaylorSeries {
    static double num = 1, den = 1;

    private static double e(int x, int n) {
        double r;
        if (n == 0)
            return 1;
        else {
            r = e(x, n - 1);
            num *= x;
            den *= n;
            return r + num / den;
        }
    }

    public static void main(String[] args) {
        int x = 2, n = 10;
        System.out.println(e(x, n));

    }
}
