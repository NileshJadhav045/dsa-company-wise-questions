

import java.util.*;

public class MinimumAreaRectangle {
    public static int minAreaRect(int[][] points) {
        int n = points.length;

        // Map to group all y-coordinates by x-coordinate
        // Key: x-coordinate, Value: set of y-coordinates
        Map<Integer, Set<Integer>> map = new HashMap<>();

        // Populate the map with all points
        for (int[] p : points) {
            map.putIfAbsent(p[0], new HashSet<>());
            map.get(p[0]).add(p[1]);
        }

        int minArea = Integer.MAX_VALUE;
        boolean foundRectangle = false;

        // Check all pairs of points to find rectangles
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Skip if points are aligned vertically or horizontally
                if (points[i][0] == points[j][0] || points[i][1] == points[j][1]) {
                    continue;
                }

                // Check if the other two corners of the rectangle exist
                if (map.get(points[i][0]).contains(points[j][1]) &&
                        map.get(points[j][0]).contains(points[i][1])) {

                    foundRectangle = true;

                    // Calculate area of the rectangle
                    int area = Math.abs(points[i][0] - points[j][0]) *
                            Math.abs(points[i][1] - points[j][1]);

                    // Update minimum area
                    minArea = Math.min(minArea, area);
                }
            }
        }

        // Return the smallest area found or 0 if no rectangle exists
        return foundRectangle ? minArea : 0;
    }

    public static void main(String[] args) {
        int[][] points = { { 1, 1 }, { 1, 3 }, { 3, 1 }, { 3, 3 }, { 2, 2 } };
        System.out.println(minAreaRect(points));
    }
}
