public class SortColors {
    /* Leetcode -> 75. Sort Colors
     * Given an array nums with n objects colored red, white, or blue, sort them in-place so 
     * that objects of the same color are adjacent, with the colors in the order red, white, and blue.

        We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
        You must solve this problem without using the library's sort function.
     */
    public static void sortColors(int[] nums) {
        int low = 0; // Pointer for 0s
        int mid = 0; // Pointer for current element
        int high = nums.length - 1; // Pointer for 2s

        // Process elements until mid pointer crosses high
        while (mid <= high) {
            switch (nums[mid]) {
                case 0 -> // If current element is 0, swap it to the front (low region)
                    swap(nums, low++, mid++);
                case 1 -> // If it's 1, it's already in the correct region; move mid forward
                    mid++;
                case 2 -> // If it's 2, swap it to the end (high region), but don't move mid yet
                    swap(nums, mid, high--);
            }
        }
    }

    // Helper function to swap elements at index i and j
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 0, 2, 1, 1, 0 };
        sortColors(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
