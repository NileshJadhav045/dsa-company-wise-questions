public class LastOcc {
    public static int lastOccurance(int nums[], int key, int i) {
        if (i == nums.length)
            return -1;
        int isFound = lastOccurance(nums, key, i + 1);
        if (isFound == -1 && nums[i] == key) {
            return i;
        }

        return isFound;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 4, 5, 6, 8, 3, 4 };
        System.out.println(lastOccurance(nums, 4, 0));
    }
}
