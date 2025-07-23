/* Leetcode -> 129. Sum Root to Leaf Numbers
 * You are given the root of a binary tree containing digits from 0 to 9 only.

    Each root-to-leaf path in the tree represents a number.

    For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
    Return the total sum of all root-to-leaf numbers. Test cases are generated 
    so that the answer will fit in a 32-bit integer.

    A leaf node is a node with no children.
 * Input: root = [1,2,3]
    Output: 25
    Explanation:
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.
    Therefore, sum = 12 + 13 = 25.
 */
public class SumRoot {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // public static int sumNumbers(TreeNode root) {
    // return sumNode(root, 0);
    // }

    public static int sumNode(TreeNode root, int currSum) {
        // Base Case
        if (root == null) {
            return 0;
        }

        // Update the current sum by appending the current node's value
        // Think of this as forming a number like 12 -> 123 by multiplying by 10 and
        // adding
        currSum = 10 * currSum + root.val;
        // If this is a leaf node, return the current number formed
        if (root.left == null && root.right == null) {
            return currSum;
        } else {
            // Recur for left and right subtrees and return their total sum
            int leftNum = sumNode(root.left, currSum);
            int rightNum = sumNode(root.right, currSum);
            return leftNum + rightNum;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("the total sum of all root-to-leaf numbers: " + sumNode(root, 0));
    }
}
