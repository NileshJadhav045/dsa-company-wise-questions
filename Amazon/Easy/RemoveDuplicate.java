package Amazon.Easy;

/* Leetcode -> 26. Remove Duplicates from Sorted Array
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates 
 * in-place such that each unique element appears only once. The relative order of 
 * the elements should be kept the same. Then return the number of unique elements 
 * in nums.

    Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

    Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
    Return k.

    Example 1:

        Input: nums = [1,1,2]
        Output: 2, nums = [1,2,_]
        Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
        It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class RemoveDuplicate {
    public static int removeDuplicate(int arr[]) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        return (i + 1);
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 1, 2 };
        int arr2[]={0,0,1,1,1,2,2,3,3,4};
        System.out.println("After removing dup ele arr size is: "+removeDuplicate(arr1));
        System.out.println("After removing dup ele arr size is: "+removeDuplicate(arr2));
    }
}