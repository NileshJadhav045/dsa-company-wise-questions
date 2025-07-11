package Amazon.Easy;
/* Leetcode -> 88. Merge Sorted Array
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, 
 * and two integers m and n, representing the number of elements in nums1 and nums2 
 * respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    The final sorted array should not be returned by the function, but instead 
    be stored inside the array nums1. To accommodate this, nums1 has a length 
    of m + n, where the first m elements denote the elements that should be 
    merged, and the last n elements are set to 0 and should be ignored. nums2 
    has a length of n.
    Example 1:

            Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
            Output: [1,2,2,3,5,6]
            Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
                         The result of the merge is [1,2,2,3,5,6] with the underlined 
                         elements coming from nums1.
 
 */
public class MargeSortedArr {
    // public static void merge(int[] nums1, int m, int[] nums2, int n) {
    //     for(int i=0, j=m; i<nums2.length; i++){ // O(log n)
    //         nums1[j]=nums2[i];
    //         j++;
    //     }
    //     Arrays.sort(nums1);

    // }
    public static void merge(int[] nums1, int m, int[] nums2, int n) { //O(n)
        int i = m - 1, j = n - 1, k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
    
    public static void main(String[] args) {
        int arr1[]={1,2,3,0,0,0};
        int arr2[]={2,5,6};
        merge(arr1, 3, arr2, arr2.length);
        for(int i=0; i<arr1.length; i++){
            System.out.print(arr1[i]+" ");
        }
    }
}
