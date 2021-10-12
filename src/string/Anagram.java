package string;

public class Anagram {

    private static boolean checkAnagram(String s1, String s2) {

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

    public static void main(String args[]) {
        String s1 = "decimal";
        String s2 = "medical";

        if (checkAnagram(s1, s2))   // Time taken O(n)
            System.out.print("Both strings are Anagram");
        else
            System.out.print("Both strings are not Anagram");
    }

}
