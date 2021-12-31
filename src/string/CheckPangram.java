package string;

public class CheckPangram {

    public static boolean checkIfPangram(String sentence) {

        int[] alpha = {97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
        char[] characters = sentence.toCharArray();

        for (char ch : characters)
            alpha[(int) ch - 97] = 0;

        for (int i : alpha)
            if (i != 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        boolean bool = checkIfPangram("thequickbrownfoxjumpsoverthelazydog");
        System.out.println(bool);
    }

}
