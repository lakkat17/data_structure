package recursion;

public class Factorial {

    private static int fact(int n) {
        if (n == 0)
            return 1;
        else
            return fact(n - 1) * n;
    }

    public static void main(String[] args) {
        int n = 6;  // n >=1
        System.out.println(fact(n));
    }
}
