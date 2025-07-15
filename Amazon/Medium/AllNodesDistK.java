import java.util.ArrayList;
import java.util.List;

/* Leetcode -> 863. All Nodes Distance K in Binary Tree
    Given the root of a binary tree, the value of a target node target,
    and an integer k, return an array of the values of all nodes that have 
    a distance k from the target node.

    You can return the answer in any order.
 * 
 * Example 1:
    Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
    Output: [7,4,1]
    Explanation: The nodes that are a distance 2 from the target node 
    (with value 5) have values 7, 4, and 1.
 */
public class AllNodesDistK {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static void printkDistanceNode(TreeNode root, int k, List<Integer> list) {
        if (root == null || k < 0)
            return;
        if (k == 0) {
            list.add(root.val);
            return;
        }
        printkDistanceNode(root.left, k - 1, list);
        printkDistanceNode(root.right, k - 1, list);
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        dinstanceKUtil(root, target, k, list);
        return list;
    }

    public static int dinstanceKUtil(TreeNode root, TreeNode target, int k, ArrayList<Integer> list) {
        if (root == null)
            return -1;
        if (root == target) {
            printkDistanceNode(root, k, list);
            return 0;
        }
        int dl = dinstanceKUtil(root.left, target, k, list);
        if (dl != -1) {
            if (dl + 1 == k) {
                list.add(root.val);
            } else {
                printkDistanceNode(root.right, k - dl - 2, list);
            }
            return 1 + dl;
        }
        int dr = dinstanceKUtil(root.right, target, k, list);
        if (dr != -1) {
            if (dr + 1 == k) {
                list.add(root.val);
            } else {
                printkDistanceNode(root.left, k - dr - 2, list);
            }
            return 1 + dr;
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        List<Integer> list = distanceK(root, root.left, 2);
        System.out.println(list);

    }
}
