package Atlassian.Easy;

import java.util.Hashtable;

public class LoggerRate {

    // Custom Pair class to hold timestamp and message
    static class Pairs {
        int x; // Timestamp
        String y; // Message

        Pairs(int x, String y) {
            this.x = x;
            this.y = y;
        }

        int getFirst() {
            return x;
        }

        String getSecond() {
            return y;
        }
    }

    public static void main(String[] args) {
        // Sample input: array of log messages with timestamps
        Pairs[] logs = new Pairs[5];
        logs[0] = new Pairs(1, "foo"); // Message "foo" at timestamp 1
        logs[1] = new Pairs(2, "bar"); // Message "bar" at timestamp 2
        logs[2] = new Pairs(3, "foo"); // Message "foo" again at timestamp 3
        logs[3] = new Pairs(8, "fba"); // Message "fba" at timestamp 8
        logs[4] = new Pairs(11, "foo"); // Message "foo" again at timestamp 11

        // Hashtable to track the last printed time of each message
        Hashtable<String, Integer> hash = new Hashtable<>();

        // Iterate through each log entry
        for (Pairs log : logs) {
            String message = log.getSecond();
            int timestamp = log.getFirst();

            // If message has been seen before
            if (hash.containsKey(message)) {
                int oldTime = hash.get(message); // Get last logged time

                // Check if at least 10 seconds have passed
                if (timestamp - oldTime >= 10) {
                    System.out.print(" true ");
                    hash.put(message, timestamp); // Update last printed time
                } else {
                    System.out.print(" false "); // Too soon to print again
                }
            } else {
                // Message not seen before: print and store the timestamp
                System.out.print(" true ");
                hash.put(message, timestamp);
            }
        }
    }
}
