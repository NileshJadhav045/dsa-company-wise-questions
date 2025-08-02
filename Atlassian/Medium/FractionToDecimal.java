import java.util.*;

/* Leetcode -> 166. Fraction to Recurring Decimal

 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

    If the fractional part is repeating, enclose the repeating part in parentheses.
    If multiple answers are possible, return any of them.
    It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
 */
public class FractionToDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        // If numerator is zero, the result is always "0"
        if (numerator == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        // Determine the sign of the result
        // If one is negative and the other is positive, prepend a "-"
        sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");

        // Convert both numbers to positive long to avoid overflow and simplify math
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append the integer part of the result
        sb.append(num / den);
        num %= den; // Get the remainder

        // If there's no remainder, it's a whole number
        if (num == 0) {
            return sb.toString();
        }

        // Otherwise, we are dealing with a fractional part
        sb.append(".");

        // Use a map to detect repeating remainders and their positions
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length()); // Store the position where this remainder was first seen

        while (num != 0) {
            num *= 10; // Multiply the remainder by 10 to simulate long division
            sb.append(num / den); // Append the quotient digit
            num %= den; // Update remainder

            // If we have seen this remainder before, we found a repeating cycle
            if (map.containsKey(num)) {
                int idx = map.get(num); // Get the start index of the repeating part
                sb.insert(idx, "("); // Insert opening bracket at start of repeating part
                sb.append(")"); // Append closing bracket
                break;
            } else {
                // Store the position of this new remainder
                map.put(num, sb.length());
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int numerator = 1, denominator = 2;
        System.out.println(fractionToDecimal(numerator, denominator));
    }
}
