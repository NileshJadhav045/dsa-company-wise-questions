public class FirstOcc {

    public static int firstOccurrence(int nums[], int key, int i) {
        if (i == nums.length)
            return -1;

        if (nums[i] == key) {
            return i;
        }

        return firstOccurrence(nums, key, i + 1);
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 4, 5, 6, 8, 3, 4 };
        System.out.println(firstOccurrence(nums, 4, 0));
    }
}
