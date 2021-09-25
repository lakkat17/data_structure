package string;

import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParentheses {

    public static void main(String[] args) {
        String s = "{[)[}";
        String s1 = "()[{}]";
        if (isValid(s) == true)
            System.out.println("Balanced");
        else
            System.out.println("Not Balanced");
    }

    public static boolean isValid(String s) {

        //ArrayDeque is faster than Stack
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);

            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty())
                return false;

            char check;
            switch (ch) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;
                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;
                case ']':
                    check = stack.pop();
                    if (check == '{' || check == '(')
                        return false;
            }
        }
        return stack.isEmpty();
    }

}
