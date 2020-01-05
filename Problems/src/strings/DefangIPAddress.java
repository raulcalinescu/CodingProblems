package strings;

/*
Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".

Example 1:
Input: address = "1.1.1.1"
Output: "1[.]1[.]1[.]1"

Example 2:
Input: address = "255.100.50.0"
Output: "255[.]100[.]50[.]0"
 */

public class DefangIPAddress {

    public String defangIpAddr(String address) {
         if (address == null)
             return null;

        StringBuilder str = new StringBuilder();     // always use StringBuilder when dealing with string concatenations
        char[] c = address.toCharArray();

        for(int i = 0; i < c.length; i++) {   // for(char c: address.toCharArray())         < -- uses less lines
            if(c[i] == '.') {             // if(String.valueOf(c).equals(".")) sb.append("[.]");
                                            // else sb.append(String.valueOf(c));
                str.append("[.]");          //  } return sb.toString();
            } else {
                str.append(c[i]);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {

    }
}
