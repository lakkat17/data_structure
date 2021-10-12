package string;

public class findDuplicates {

    // Hashing
    private static void findDuplicateWithHashing(String s){
        int[] H = new int[26];
        for(char c : s.toCharArray())
            H[(int)c - 97]++;

        for(int i=0;i<H.length;i++){
            if(H[i]>1)
                System.out.println("Duplicate character " + (char)(i+97) + " found " + H[i] + " times");
        }
    }

    // using bits
    private static void findDuplicateUsingBits(String s){
        int H = 0 , x = 0;
        for(int i=0;i<s.length();++i){
            x = 1;
            x = x << (int)s.charAt(i) - 97;
            if((x & H)>0)  // masking (checking)
                System.out.println("Alphabet " + s.charAt(i) + " is duplicate");
            else
                H = (x | H);  // Merging (Setting bit ON)
        }
    }

    public static void main(String[] args) {
        String s = "findings";
        findDuplicateWithHashing(s);
        findDuplicateUsingBits(s);
    }
}
