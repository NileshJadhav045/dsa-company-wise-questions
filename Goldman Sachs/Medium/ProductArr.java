public class ProductArr {
    public static void productExceptSelf(int[] nums) {
        int n = nums.length;

        // Output array to store the final result
        int res[] = new int[n];

        // Variable to store the product of elements to the left of current index
        int prod = 1;

        // First pass (Left to Right):
        // res[i] contains the product of all elements to the left of index i
        for (int i = 0; i < n; i++) {
            res[i] = prod; // Store the product so far (excluding current element)
            prod *= nums[i]; // Update product for next index
        }

        // Reset product for the second pass
        prod = 1;

        // Second pass (Right to Left):
        // Multiply with the product of all elements to the right of index i
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= prod; // Multiply existing value with product from the right
            prod *= nums[i]; // Update product for the next element to the left
        }

        for(int x: res){
            System.out.print(x+" ");
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        productExceptSelf(nums);
    }
}
