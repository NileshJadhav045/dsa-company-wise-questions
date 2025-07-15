public class LongPalindromSubstr {
    public static String longestPalindrome(String s) {
        int start = 0, end = 1;
        int l = 0, r = 0;
        for (int i = 0; i < s.length(); i++) {
            l = i;
            r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                // Even length palindrome (center between i and i+1)
                if (r - l + 1 > end) {
                    start = l;
                    end = r - l + 1;
                }
                l--;
                r++;
            }

            // Odd length palindrome (center at i)
            l = i - 1;
            r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > end) {
                    start = l;
                    end = r - l + 1;
                }
                l--;
                r++;
            }
        }
        return s.substring(start, start + end);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
