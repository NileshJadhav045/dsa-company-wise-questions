import java.util.PriorityQueue;

public class RecognizeString {
    public static String reorganizeString(String s) {
        int charCount[] = new int[26];
        // Count occurrences of each character
        for (char c : s.toCharArray()) {
            charCount[c - 'a'] = charCount[c - 'a'] + 1;
        }

        // Max heap (priority queue) to store characters sorted by frequency (highest first)
        var pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(b[1], a[1]));
        // Add characters with non-zero frequency into the heap
        for (int i = 0; i < 26; i++) {
            if (charCount[i] > 0) {
                pq.offer(new int[] { i + 'a', charCount[i] }); // Store ASCII and frequency
            }
        }
        StringBuilder sb = new StringBuilder();
        // Pull out the first character block to start the string
        int[] block = pq.poll(); 
        sb.append((char) block[0]); // Add the character to the result
        block[1]--; // Decrease its count
        // Continue building the result string
        while (!pq.isEmpty()) {
            int[] next = pq.poll(); // Get the next most frequent character
            sb.append((char) next[0]); // Append to result
            next[1]--;

            // Put the previous block back into the heap if it still has remaining frequency
            if (block[1] > 0) {
                pq.offer(block);
            }

            // Update block to the current one for the next loop
            block = next;
        }

        // If after all this, the last character still has remaining frequency > 0,
        // we can't build a valid string (adjacent same characters would appear)
        if (block[1] > 0) {
            return ""; // Not possible
        } else {
            return sb.toString(); // Valid reorganized string
        }
    }
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(reorganizeString(s));
    }
}
