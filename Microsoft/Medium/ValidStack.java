import java.util.Stack;
/* Leetcode -> 946. Validate Stack Sequences
 * Given two integer arrays pushed and popped each with distinct values, 
 * return true if this could have been the result of a sequence of push 
 * and pop operations on an initially empty stack, or false otherwise.
 *  
 * Example 1:
    Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
    Output: true
    Explanation: We might do the following sequence:
    push(1), push(2), push(3), push(4),
    pop() -> 4,
    push(5),
    pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 
 */
public class ValidStack {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = pushed.length;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
            stack.push(pushed[i]);
        }
        while (!stack.isEmpty() && popped[j] == stack.peek()) {
            stack.pop();
            j++;
        }

        return stack.isEmpty() && j == n;
    }

    public static void main(String[] args) {
        int[] pushed = { 1, 2, 3, 4, 5 };
        int[] popped = { 4, 5, 3, 2, 1 };
        System.out.println(validateStackSequences(pushed, popped));
    }
}