package string;

public class OperationsOnString {

    String s;

    OperationsOnString() {
        s = new String();
    }

    OperationsOnString(String s) {
        this.s = s;
    }

    private String toUpperCase() {
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch > 96 && ch < 123)
                c[i] = (char) (ch - 32);
            else c[i] = ch;
        }
        return new String(c);
    }

    private String toggleCase() {
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch >= 97 && ch <= 122)
                c[i] = (char) (ch - 32);
            else if (ch >= 65 && ch <= 90)
                c[i] = (char) (ch + 32);
            else c[i] = ch;
        }
        return new String(c);
    }

    private int countVowels() {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                count++;
        }
        return count;
    }

    private int countWords() {
        int space = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; ++i)
            if (ch[i] == ' ' && ch[i - 1] != ' ')
                space++;
        return space + 1;
    }

    @Override
    public String toString() {
        return s;
    }

    public static void main(String[] args) {
        OperationsOnString op1 = new OperationsOnString("welC^mE");
        OperationsOnString op2 = new OperationsOnString("welC^mE");
        OperationsOnString op3 = new OperationsOnString("My name is Robert");
        System.out.println(op1.toUpperCase());
        System.out.println(op2.toggleCase());
        System.out.println("Vowels count in " + op2.toString() + " is: " + op2.countVowels());
        System.out.println("Number of words in: " + op3.toString() + " is: " + op3.countWords());
    }

}
