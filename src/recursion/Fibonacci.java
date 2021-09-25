package recursion;

// 0 1 1 2 3 5 8 13 21
public class Fibonacci {
    static long f0 = 0, f1 = 1, r;

    private static void fibLoop(int n) {
        System.out.print(f0 + " " + f1 + " ");
        while (n > 1) {
            r = f0 + f1;
            f0 = f1;
            f1 = r;
            n--;
            System.out.print(r + " ");
        }
    }

    private static long fibo(int n) {
        if (n <= 1)
            return n;
        else {
            return fibo(n - 2) + fibo(n - 1);
        }
    }

    // reduced repetitive recursive calls using memoization
    static int F[] = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    private static int mFibo(int n) {
        if (n <= 1) {
            F[n] = n;
            return n;
        } else {
            if (F[n - 2] == -1)
                F[n - 2] = mFibo(n - 2);
            if (F[n - 1] == -1)
                F[n - 1] = mFibo(n - 1);

            return mFibo(n - 2) + mFibo(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 10;   //   n >= 0
        System.out.println("Recursive call: " + fibo(n));  // to print a value

        fibLoop(n);  // to print series

        System.out.println("\nMemoization Call: " + mFibo(n)); // memoization call
    }

}
