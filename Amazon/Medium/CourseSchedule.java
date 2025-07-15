import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/* Leetcode -> 207. Course Schedule
 * There are a total of numCourses courses you have to take, labeled from 0 
 * to numCourses - 1. You are given an array prerequisites where 
 * prerequisites[i] = [ai, bi] indicates that you must take course b[i] first 
 * if you want to take course a[i].

        For example, the pair [0, 1], indicates that to take course 0 you have to 
        first take course 1.
        Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to store course dependencies
        ArrayList<Integer>[] adjlist = new ArrayList[numCourses];
        // Array to track the number of prerequisites (in-degrees) for each course
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjlist[i] = new ArrayList<>();
        }

        // Build the graph and compute in-degrees
        for (int[] x : prerequisites) {
            int course = x[0]; // course to take
            int prereq = x[1]; // prerequisite course
            adjlist[prereq].add(course); // prereq -> course
            indegree[course]++; // increment indegree of course
        }
        // Add all courses with 0 in-degree (no prerequisites) to the queue
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        // BFS traversal (Kahn's Algorithm)
        while (!q.isEmpty()) {
            int x = q.poll(); // Take course with no prereqs
            count++; // One more course completed
            for (int i : adjlist[x]) {
                if (--indegree[i] == 0) {
                    q.add(i); // If no more prereqs, add to queue
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 } };
        System.out.println(canFinish(numCourses, prerequisites));
    }
}
