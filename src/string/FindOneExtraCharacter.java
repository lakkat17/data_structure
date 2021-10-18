package string;

public class FindOneExtraCharacter {

    private static int findExtra(String s1, String s2) {
        int[] H = new int[26];

        for (char c1 : s1.toCharArray())
            H[(int) c1 - 97]++;

        for (char c2 : s2.toCharArray())
            H[(int) c2 - 97]--;

        for (int i = 0; i < H.length; ++i) {
            if (H[i] != 0)
                return (i + 97);
        }
        return 0;
    }


    public static void main(String[] args) {
        String s1 = "kxml";
        String s2 = "kxmel";

        int ch = findExtra(s1, s2);
        if (ch != 0)
            System.out.println("Extra Character is: " + (char) ch);
        else
            System.out.println("No Extra character found");
    }

}
