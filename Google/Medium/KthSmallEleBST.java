package Google.Medium;

import java.util.*;

/* Leetcode -> 230. Kth Smallest Element in a BST
 * Given the root of a binary search tree, and an integer k, return the kth 
 * smallest value (1-indexed) of all the values of the nodes in the tree.
 * 
 */
public class KthSmallEleBST {
    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static int kthSmallest(Node root, int k) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans.get(k - 1);
    }

    static void inorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.left.right = new Node(2);
        System.out.println("Kth Smallest Element in BST: " + kthSmallest(root, 3));
    }
}
