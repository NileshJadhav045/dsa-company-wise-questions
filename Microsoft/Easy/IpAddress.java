package Microsoft.Easy;
/*Leetcode -> 1108. Defanging an IP Address
 * Given a valid (IPv4) IP address, return a defanged version of that IP address.

    A defanged IP address replaces every period "." with "[.]".
 */
public class IpAddress {
    public static String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                sb.append("[.]");
            } else {
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "1.1.1.1";
        System.out.println(defangIPaddr(s));
    }
}
