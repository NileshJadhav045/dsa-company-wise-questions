/*Leetcode -> 191. Number of 1 Bits
 * Given a positive integer n, write a function that returns the number of 
 * set bits in its binary representation (also known as the Hamming weight).
 * 
 *      Input: n = 2147483645
        Output: 30

        Explanation:
        The input binary string 1111111111111111111111111111101 has a total of
        thirty set bits.
 */
public class NumbersOfOneBit {
    public static int hammingWeight(int n) { //O(log n)
        int count = 0;
        for (int i = 0; i <= 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n /= 2;
        }
        return count;
    }
    public static void main(String[] args) {
        int  n = 11;
        int m = 2147483645;
        System.out.println(hammingWeight(n));
        System.out.println(hammingWeight(m));
    }
}
