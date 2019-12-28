package random;

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

         if (address.length() == 1)
             return address;

        StringBuilder str = new StringBuilder();     // always use StringBuilder when dealing with string concatenations
        char[] c = address.toCharArray();
        for(int i = 0; i < c.length; i++) {

        }
        return null;
    }

    public static void main(String[] args) {

    }
}
