package algorithms;

import java.util.*;

public class MakingAnagrams {

    public static void anagrams(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        StringBuilder temp = new StringBuilder();
        int countDiffAnagram = 0;

        for (int i = 0; i < aArr.length; i++)
            for (int j = 0; j < bArr.length; j++)
                if (aArr[i] == bArr[j]) {
                    temp.append(Character.toString(aArr[i]));
                    bArr[j] = ' ';
                    break;
                }
        countDiffAnagram = a.length() + b.length() - 2*temp.length();
        System.out.println(countDiffAnagram);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String a = scanner.nextLine();

        String b = scanner.nextLine();

        scanner.close();
        MakingAnagrams.anagrams(a,b);
    }
}