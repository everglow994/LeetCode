package BinaryTree;

import java.util.Stack;

public class ValidateBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    // 1. Divide and Conquer, code version 1
    // time: O(N)
    // space: O(N)
    // divide and conquer的思路是自顶向下
    // 这里采用自底向上的参数返回
    // 条件是 parent node 的值 必须满足左右子树最大最小值的条件
    private class ResultType {
        int max, min;
        boolean isBST;
        ResultType(int max, int min, boolean isBST) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }

    public ResultType helper(TreeNode node) {

        if(node == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }

        ResultType left = helper(node.left);
        ResultType right = helper(node.right);



        if(!left.isBST || !right.isBST) {
            return new ResultType(0, 0, false);
        }

        if(node.left != null && left.max >= node.val) {
            return new ResultType(0, 0, false);
        }

        if(node.right != null && right.min <= node.val) {
            return new ResultType(0, 0, false);
        }

        return new ResultType(Math.max(node.val, left.max), Math.min(node.val, left.min), true);
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        ResultType res = helper(root);
        return res.isBST;
    }

    // 2. Divide and Conquer code version 2
    // 这里采用自顶向下的参数返回条件
    // 子树必须满足来自parent node 的值域范围

    public boolean helper2(TreeNode root, long min, long max) {
        if(root == null) {
            return true;
        }

        if(root.val <= min || root.val >= max) {
            return false;
        }

        return helper2(root.left, min, root.val) && helper2(root.right, root.val, max);
    }


    public boolean isValidBST2(TreeNode root) {
        if(root == null) {
            return true;
        }
        return helper2(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    // 3. Divide and Conquer code version 3
//    private class ResultType {
//        TreeNode max, min;
//        boolean isBST;
//        ResultType(TreeNode max, TreeNode min, boolean isBST) {
//            this.max = max;
//            this.min = min;
//            this.isBST = isBST;
//        }
//    }
//
//    public ResultType helper(TreeNode root) {
//        if(root == null) {
//            return new ResultType(null, null, true);
//        }
//
//        ResultType left = helper(root.left);
//        ResultType right = helper(root.right);
//
//        if(!left.isBST || !right.isBST) {
//            return new ResultType(null, null, false);
//        }
//
//        if(root.left != null && left.max.val >= root.val) {
//            return new ResultType(null, null, false);
//        }
//
//        if(root.right != null && right.min.val <= root.val) {
//            return new ResultType(null, null, false);
//        }
//
//        TreeNode min = root.left == null ? root : left.min;
//        TreeNode max = root.right == null ? root : right.max;
//
//        return new ResultType(max, min, true);
//    }
//
//    public boolean isValidBST(TreeNode root) {
//        if(root == null) {
//            return true;
//        }
//        ResultType res = helper(root);
//        return res.isBST;
//    }


    // 4. traverse
    public boolean isValidBST4(TreeNode root) {
        if(root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack();
        TreeNode prev = null;
        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if(prev != null && cur != null && prev.val >= cur.val) {
                    return false;
                }
                prev = cur;
                cur = cur.right;
            }
        }
        return true;
    }

}
