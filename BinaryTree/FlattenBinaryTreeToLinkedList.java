package BinaryTree;

public class FlattenBinaryTreeToLinkedList {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }



    // 1. Divide and Conquer
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if(root == null) {
            return null;
        }

        TreeNode lastLeft = helper(root.left);
        TreeNode lastRight = helper(root.right);

        if(lastLeft != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            lastLeft.right = temp;
        }

        if(lastRight != null) {
            return lastRight;
        }

        if(lastLeft != null) {
            return lastLeft;
        }

        return root;
    }

    // 2. Traverse
    public void flatten1(TreeNode root) {
        if(root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        flatten1(left);
        flatten1(right);

        root.right = left;
        root.left = null;

        TreeNode cur = root;
        while(cur.right != null) {
            cur = cur.right;
        }

        cur.right = right;
    }
}
