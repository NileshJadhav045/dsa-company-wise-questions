public class FindMin {
    /* Leetcode -> 153. Find Minimum in Rotated Sorted Array
     * Suppose an array of length n sorted in ascending order is rotated between 1
     * and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
     * 
     * [4,5,6,7,0,1,2] if it was rotated 4 times.
     * [0,1,2,4,5,6,7] if it was rotated 7 times.
     * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
     * in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
     * 
     * Given the sorted rotated array nums of unique elements, return the minimum
     * element of this array.
     * 
     * You must write an algorithm that runs in O(log n) time.
     */
    public static int findMin(int[] nums) {
        int n = nums.length; // Length of the array
        int s = 0; // Start pointer
        int e = n - 1; // End pointer

        while (s <= e) {
            // Calculate middle index
            int mid = s + (e - s) / 2;

            // Calculate indices of previous and next elements in circular manner
            // Using modulo ensures wrap-around when at array edges
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;

            // If the middle element is smaller than both neighbors, it's the minimum
            if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
                return nums[mid];
            }

            // If right half is sorted, then the pivot/minimum is in the left half
            if (nums[mid] <= nums[e]) {
                e = mid - 1; // Search left side
            }
            // Otherwise, left half is sorted, so pivot is in the right half
            else {
                s = mid + 1; // Search right side
            }
        }

        // If array is empty or something unexpected happens
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(findMin(nums));
    }
}
