// package Amazon.Easy.Medium;

/* Leetcode -> 1094. Car Pooling
 * There is a car with capacity empty seats. The vehicle only drives east 
 * (i.e., it cannot turn around and drive west).

    You are given the integer capacity and an array trips where trips[i] = [numPassengersi,
    fromi, toi] indicates that the ith trip has numPassengersi passengers and the locations
    to pick them up and drop them off are fromi and toi respectively. The locations are 
    given as the number of kilometers due east from the car's initial location.

    Return true if it is possible to pick up and drop off all passengers for all 
    the given trips, or false otherwise.
 */
public class CarPooling {
    public static boolean carPooling(int[][] trips, int capacity) {
        // Array to represent the net number of passengers at each point
        int m[] = new int[1001];
        // Mark the number of passengers getting in and out at each location
        for (int a[] : trips) {
            m[a[1]] += a[0]; // Passengers get in at start location a[1]
            m[a[2]] -= a[0]; // Passengers get out at end location a[2]
        }

        // Simulate the journey from location 0 to 1000
        for (int i = 0; capacity >= 0 && i < 1001; i++) {
            capacity -= m[i]; // Subtract net passengers at each point
        }
        return capacity >= 0;
    }

    public static void main(String[] args) {
        int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
        System.out.println(carPooling(trips, 5));
    }
}
