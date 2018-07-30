package BinaryTree;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }


    // 1. DFS recursion
    // time: O(N)
    // space: O(H) recursion depth
    public List<Integer> preorder1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        recursion(root, res);
        return res;
    }

    public void recursion(TreeNode root, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        recursion(root.left, list);
        recursion(root.right, list);
    }

    // 2. DFS iteration method 1
    //  time: O(N)
    //  space: O(N)
    public List<Integer> preorder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if(root == null) {
            return res;
        }

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode top = stack.pop();
            res.add(top.val);
            if(top.right != null) {
                stack.push(top.right);
            }
            if(top.left != null) {
                stack.push(top.left);
            }
        }
        return res;
    }

    // 3. DFS method 2
    // time: O(N)
    // space: O(N)
    public List<Integer> preorder3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if(root == null) {
            return res;
        }

        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                res.add(cur.val);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }

        return res;
    }

    // 4. Divide and Conquer
    // time: O(N)
    // space: O(N)
    public List<Integer> preorder4(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null) {
            return res;
        }

        List<Integer> left = preorder4(root.left);
        List<Integer> right = preorder4(root.right);

        res.add(root.val);

        // 记住了 addAll method in list interface
        res.addAll(left);
        res.addAll(right);

        return res;
    }
}
