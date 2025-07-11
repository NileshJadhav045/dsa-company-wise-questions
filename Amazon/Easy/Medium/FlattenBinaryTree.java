public class FlattenBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void flatten(TreeNode root) {
        // Traverse the tree starting from the root
        while (root != null) {
            // If there is a left subtree, we need to rewire it
            if (root.left != null) {
                // Find the rightmost node of the left subtree
                TreeNode curr = root.left;
                while (curr.right != null) {
                    curr = curr.right;
                }
                // Attach the original right subtree to the rightmost node of the left subtree
                curr.right = root.right; 
                // Move the entire left subtree to the right
                root.right = root.left; 
                // Set the left child to null as required by the problem
                root.left = null; 
            }
            root = root.right; // Move to the next right node
        }
    }

    public static void print(TreeNode root){
        if (root == null) {
            return;
        }

        print(root.left);
        System.out.print(root.val+" -> ");
        print(root.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        flatten(root);
        print(root);
        System.out.println("null");
    }
}
