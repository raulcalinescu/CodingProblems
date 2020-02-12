package Coding_Assesments.IBMCloudApps;

public class ReverseString {
    public static String reverseString(String str) {
        char[] rev = str.toCharArray();
        char[] given = str.toCharArray();
        for(int i=0, j=str.length()-1; i<str.length(); i++, j--) {
            rev[j] = given[i];
        }
        String result = new String(rev);
        return result;
    }

    public static void main(String[] args) {
        String str = new String("Hello World");
        System.out.println(reverseString(str));
    }
}
