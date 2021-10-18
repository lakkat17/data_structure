package string;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ReverseWords {

    public static String reverse(String[] s) {
        String res = "";
        for (int i = s.length - 1; i >= 0; --i) {
            res += s[i];
            if (i != 0)
                res += " ";
        }
        return res;
    }

    public static String reverse(String s) {
        String res = "";
        int i = s.length() - 1;
        int end = s.length(), start;
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                start = i + 1;
                while (start < end) {
                    res += s.charAt(start);
                    start++;
                }
                end = i;
                res += ' ';
            }
            --i;
        }
        i++;
        while (i < end) {
            res += s.charAt(i);
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "I love Programming very much";
        Pattern p = Pattern.compile("\\s");
        String[] str = p.split(s);
        System.out.println("Reversed String is: " + reverse(str));

        System.out.println("Reversed String is: " + reverse(s));
    }
}
