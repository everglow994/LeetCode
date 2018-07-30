package Coding;

public class TreeAmplitude {

    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public int amplitude(TreeNode root) {
        if(root == null)
            return 0;
        return helper(root, root.val, root.val);
    }

    private int helper(TreeNode root, int max, int min) {

        if(root == null) {
            return max - min;
        }

        max = root.val > max ? root.val : max;
        min = root.val < min ? root.val : min;

        return Math.max(helper(root.left, max, min), helper(root.right, max, min));
    }




//    public int Solution(TreeNode root) {
//        if (root == null)   return 0;
//        return helper(root, root.val, root.val);
//    }
//
//    private int helper(TreeNode root, int min, int max) {
//        if (root == null)   return max - min;
//
//        if (root.val < min) min = root.val;
//        if (root.val > max) max = root.val;
//
//        return Math.max(helper(root.left, min, max), helper(root.right, min, max));
//    }
}
