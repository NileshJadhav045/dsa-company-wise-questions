/* Leetcode -> 709. To Lower Case
 * Given a string s, return the string after replacing every uppercase 
 * letter with the same lowercase letter.
 * 
 * Input: s = "Hello"
 * Output: "hello"
 */
public class ToLowerCase {
    public static String toLowerCase(String s) {
        //return s.toLowerCase();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 65 && ch[i] <= 90) {
                ch[i] = (char) (ch[i] + 32);
            }
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        String str="HellO";
        System.out.println(toLowerCase(str));
    }
}
