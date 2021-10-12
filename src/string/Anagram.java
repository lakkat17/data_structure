package string;

public class Anagram {

    private static boolean checkAnagramWithHash(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        int[] H = new int[26];       // HashTable to handle alphabets

        for (char c : s1.toCharArray())       // comparisons -> n
            H[(int) c - 97]++;    // incrementing in HashTable

        for (char c : s2.toCharArray())    // comparisons -> n
            H[(int) c - 97]--;    // decrementing in HashTable

        for (int e : H)
            if (e != 0)
                return false;

        return true;
    }

    // Doesn't work when there are duplicate letter in a string
    private static boolean checkAnagramWithBits(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        int H = 0, x = 0;       // int with 32 bits range

        for (char c : s1.toCharArray()) {
            x = 1;
            x = x << (int) c - 97;
            H = x | H;  // merging to set bit ON
        }

        for (char c : s2.toCharArray()) {
            x = 1;
            x = x << (int) c - 97;
            if ((x & H) == 0)   // masking to check whether bit is ON or not
                return false;
        }
        return true;

    }

    public static void main(String args[]) {
        String s1 = "verbose";
        String s2 = "observe";
        String s3 = "medical";
        String s4 = "decimal";

        if (checkAnagramWithHash(s1, s2))   // Time taken O(n)
            System.out.println("Both strings are Anagram");
        else
            System.out.println("Both strings are not Anagram");

        System.out.println("---------------------------------------------------------------------------");

        if (checkAnagramWithBits(s3, s4))   // Time taken O(n)
            System.out.println("Both strings are Anagram");
        else
            System.out.println("Both strings are not Anagram");
    }
}
