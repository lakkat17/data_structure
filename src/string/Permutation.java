package string;

public class Permutation {

    int[] A;
    char[] res;

    Permutation(int size) {
        A = new int[size];
        res = new char[size];
    }

    // Here we are using recursion at every character selection step in res and also achieving backtracking
    // Using loop for each scan for character availability in A.
    // backtracking will help us use brute force for every permutation possible.
    private void perm1(String s, int k) {

        if (k == s.length())
            System.out.print(String.valueOf(res) + " ");
        else
            for (int i = 0; i < s.length(); ++i) {
                if (A[i] == 0) {
                    res[k] = s.charAt(i);
                    A[i] = 1;
                    perm1(s, k + 1);
                    A[i] = 0;
                }
            }
    }

    private static char[] swap(char[] s, int index1, int index2) {
        char temp = s[index1];
        s[index1] = s[index2];
        s[index2] = temp;
        return s;
    }

    // 2nd way (using swapping)
    private static void perm2(char[] s, int l, int h) {

        if (l == h)
            System.out.print(String.valueOf(s) + " ");
        else
            for (int i = l; i <= h; ++i) {
                s = swap(s, l, i);
                perm2(s, l + 1, h);
                s = swap(s, l, i);
            }
    }

    public static void main(String[] args) {
        String s1 = "ABC";
        char[] s2 = {'A', 'B', 'C'};
        Permutation p = new Permutation(s1.length());
        p.perm1(s1, 0);
        System.out.println();
        perm2(s2, 0, s2.length - 1);
    }
}
