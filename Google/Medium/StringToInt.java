package Google.Medium;

/* Leetcode -> 8. String to Integer (atoi)
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit 
 * signed integer.

    The algorithm for myAtoi(string s) is as follows:

    Whitespace: Ignore any leading whitespace (" ").
    Signedness: Determine the sign by checking if the next character is 
                '-' or '+', assuming positivity if neither present.
    Conversion: Read the integer by skipping leading zeros until a non-digit 
                character is encountered or the end of the string is reached. 
                If no digits were read, then the result is 0.
    Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], 
              then round the integer to remain in the range. Specifically, integers 
              less than -231 should be rounded to -231, and integers greater than 231 - 1 
              should be rounded to 231 - 1.
    Return the integer as the final result.
 */
public class StringToInt {
    public static int myAtoi(String s) {
        int i = 0; // Pointer to traverse the string
        int ans = 0; // Result variable
        int sign = 1; // To store sign of the number (+1 or -1)

        // Step 1: Skip leading whitespaces
        while (i < s.length() && s.charAt(i) == ' ')
            i++;

        // Step 2: If the string only had spaces
        if (i == s.length())
            return 0;

        // Step 3: Handle optional sign character '+' or '-'
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }

        // Step 4: Convert digits to integer
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int num = s.charAt(i) - '0'; // Convert char to digit
            i++;

            // Step 5: Check for overflow/underflow
            if (ans > Integer.MAX_VALUE / 10 ||
                    (ans == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            // Step 6: Append digit
            ans = ans * 10 + num;
        }

        // Step 7: Apply sign and return
        return ans * sign;
    }

    public static void main(String[] args) {
        String s = "42";
        System.out.println(myAtoi(s));

        /*
         * Explanation:
            The underlined characters are what is read in and the caret is the current reader position.
            Step 1: "42" (no characters read because there is no leading whitespace)
                    ^
            Step 2: "42" (no characters read because there is neither a '-' nor '+')
                    ^
            Step 3: "42" ("42" is read in)
         */
    }
}
