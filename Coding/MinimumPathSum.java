package Coding;

public class MinimumPathSum {

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }


    public int path(TreeNode root) {
        if(root == null) {
            return 0;
        }

        if(root.left == null && root.right == null) {
            return root.val;
        }

        if(root.left == null) {
            return path(root.right) + root.val;
        }

        if(root.right == null) {
            return path(root.left) + root.val;
        }
        return Math.min(path(root.left), path(root.right)) + root.val;

    }

}
