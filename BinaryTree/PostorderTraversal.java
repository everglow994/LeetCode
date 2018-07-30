package BinaryTree;

import java.util.*;

public class PostorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 1. DFS stack: reverse preorder
    // time: O(N)
    // space: O(N)
    public List<Integer> postOrder1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();

        if(root == null) {
            return ans;
        }

        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);

            if(node.left != null) {
                stack.push(node.left);
            }

            if(node.right != null) {
                stack.push(node.right);
            }
        }

        Collections.reverse(ans);
        return ans;
    }

    // 2. DFS + LinkedList
    // time: O(N)
    // space: O(N)
    public List<Integer> postOrder2(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack();
        if(root == null) {
            return ans;
        }

        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null ) {
            if(cur != null) {
                ans.addFirst(cur.val);
                stack.push(cur);
                cur = cur.right;
            } else {
                cur = stack.pop();
                cur = cur.left;
            }
        }

        return ans;
    }


    // 3. DFS iteration ***   死记的版本
    public List<Integer> postOrder3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();

        if(root == null) {
            return ans;
        }

        TreeNode prev = null;
        stack.push(root);

        while(!stack.isEmpty()) {
           TreeNode cur = stack.peek();
           if(prev == null || prev.right == cur || prev.left == cur) {
                if(cur.left != null) {
                    stack.push(cur.left);
                } else if(cur.right != null) {
                    stack.push(cur.right);
                }
           } else if(cur.left == prev) {
                if(cur.right != null) {
                    stack.push(cur.right);
                }
           } else {
               ans.add(cur.val);
               stack.pop();
           }

            prev = cur;
        }

        return ans;
    }

}
