package Amazon.Easy;

public class MissingNum {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            n = n ^ i;
            n = n ^ nums[i];

        }
        return n;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 3 };
        System.out.println("The missing number is: "+missingNumber(nums));
    }
}
