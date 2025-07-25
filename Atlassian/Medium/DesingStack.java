package Atlassian.Medium;

import java.util.Stack;
/* Leetcode -> 1381. Design a Stack With Increment Operation
 * Design a stack that supports increment operations on its elements.

    Implement the CustomStack class:

    CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack.
    void push(int x) Adds x to the top of the stack if the stack has not reached the maxSize.
    int pop() Pops and returns the top of the stack or -1 if the stack is empty.
    void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, increment all the elements in the stack.
 */
public class DesingStack {
    static class CustomStack {
        static Stack<Integer> s1; // Main stack
        static Stack<Integer> s2; // Helper stack for increment operation
        static int maxSize; // Maximum capacity of the custom stack
        static int currSize; // Current number of elements in the stack

        // Constructor: Initializes the stack with a given maximum size
        public CustomStack(int maxSize) {
            currSize = 0;
            this.maxSize = maxSize;
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        // Pushes an element x onto the stack if it hasn’t reached maxSize
        public static void push(int x) {
            if (currSize < maxSize) {
                s1.push(x);
                currSize++;
            }
        }

        // Pops and returns the top element from the stack
        // Returns -1 if the stack is empty
        public static int pop() {
            if (currSize == 0)
                return -1;
            currSize--;
            return s1.pop();
        }

        // Increments the bottom k elements of the stack by val
        public static void increment(int k, int val) {
            // Step 1: Reverse the stack so that we can access bottom elements
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            // Step 2: Increment the bottom k elements (which are now on top of s2)
            while (!s2.isEmpty() && k > 0) {
                s1.push(s2.pop() + val); // Increment and push back to s1
                k--;
            }

            // Step 3: Push the remaining elements (if any) back to s1 without changes
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.increment(2, 100);
        System.err.println(customStack.pop());
        System.err.println(customStack.pop());
        
    }
}
