public class PowerOfThree {
    public static boolean isPowerOfThree(int n) {
        //return Integer.toString(n, 3).matches("^10*$"); // O(Log4n) one line code
        if (n == 0) {
            return true;
        }

        while (n % 3 == 0) {
            n /= 3;
        }
        if (n == 1) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int n = 27;
        System.out.println(isPowerOfThree(n));
        int m=28;
        System.out.println(isPowerOfThree(m));
    }
}
