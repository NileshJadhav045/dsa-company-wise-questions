
public class Leetcode4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // Ensure nums1 is the smaller array (so binary search is done on the smaller one)
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0, right = n1;

        // Binary search on nums1
        while (left <= right) {
            // Partition index for nums1
            int mid1 = left + (right - left) / 2;

            // Partition index for nums2 such that left half has (n1+n2+1)/2 elements
            int mid2 = (n1 + n2 + 1) / 2 - mid1;

            // Elements just before and after the partition in nums1
            double l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
            double r1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];

            // Elements just before and after the partition in nums2
            double l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
            double r2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];

            // Correct partition found
            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0) {
                    // Even length → median is average of max(left side) and min(right side)
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                } else {
                    // Odd length → median is the max of the left side
                    return (double) Math.max(l1, l2);
                }
            } // Too many elements taken from nums1 → move left
            else if (l1 > r2) {
                right = mid1 - 1;
            } // Too few elements taken from nums1 → move right
            else {
                left = mid1 + 1;
            }
        }

        // Should never reach here for valid input
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
