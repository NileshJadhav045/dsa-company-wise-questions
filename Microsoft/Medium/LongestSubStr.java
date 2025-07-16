public class LongestSubStr {
    /* Leetcode -> 3. Longest Substring Without Repeating Characters
     * Given a string s, find the length of the longest substring 
     * without duplicate characters.
     * 
        Input: s = "abcabcbb"
        Output: 3
        Explanation: The answer is "abc", with the length of 3.
     */
    public static int lengthOfLongestSubstring(String s) {
        int freq[] = new int[256];
        int n = s.length();
        int i = 0;
        int j = 0;
        int ans = 0;
        while (i < n) {
            if (freq[s.charAt(i)] == 1) {
                while (freq[s.charAt(i)] == 1) {
                    freq[s.charAt(j)]--;
                    j++;
                }
            }
            freq[s.charAt(i)]++;
            ans = Math.max(ans, i - j + 1);
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
