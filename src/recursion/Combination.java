package recursion;

public class Combination {

    /*
    Here we used pascal's triangle.
    We can simply calculate all factorials required to calculate combination.
    nCr = n!/r!(n-r)! we have to find n! , r! & (n-r)! using factorial logic.
    */
    private static int comb(int n, int r) {
        if (r == 0 || n == r)
            return 1;
        else
            return comb(n - 1, r - 1) + comb(n - 1, r);
    }

    public static void main(String[] args) {
        int n = 4, r = 2;
        System.out.println(comb(n, r));
    }
}
