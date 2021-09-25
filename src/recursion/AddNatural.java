package recursion;

public class AddNatural {

    private static int sum1(int n) {
        if (n == 1)
            return 1;
        else
            return sum1(n - 1) + n;
    }

    // using mathematical formula
    private static int sum2(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        int n = 5;   //   n >= 1
        System.out.println(sum1(n));
        System.out.println(sum2(n));
    }
}
