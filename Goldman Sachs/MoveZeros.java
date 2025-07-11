public class MoveZeros {
    /* Leetcode -> 283. Move Zeroes
     * Given an integer array nums, move all 0's to the end of it while maintaining
     * the relative order of the non-zero elements.

        Note that you must do this in-place without making a copy of the array.
     */
    public static void moveZeroes(int arr[]) {
        int z = -1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                z = i;
                break;
            }
        }
        if (z == -1) return;
        for (int i = z + 1; i < n; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[z];
                arr[z] = temp;
                z++;
            }
        }
    }

    public static void printArr(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 3, 12 };
        System.out.print("Before Shifting zeroes: ");
        printArr(arr);
        System.out.print("\nAfter Shiftinf Zeroes: ");
        moveZeroes(arr);
        printArr(arr);
    }
}
