package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    // 1. DFS recursion
    // time: O(N)
    // space: O(height of tree) recursion stack
    public List<Integer> inorder1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        dfs(root, ans);
        return ans;
    }

    public void dfs(TreeNode node, List<Integer> list) {
        if(node == null) return;
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }


    // 2. DFS stack
    // time: O(N)
    // space: O(N)
    public List<Integer> inorder2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return ans;

        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                ans.add(cur.val);
                cur = cur.right;
            }
        }

        return ans;
    }


    // 3. DFS: (Morris Traversal)
    // time: O(N)
    // space: O(1) trade-off(modify tree structure)

    public List<Integer> inorder3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        TreeNode cur = root;
        while(cur != null) {
            if(cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            } else {
                TreeNode pre = cur.left;
                while(pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur;
                cur = cur.left;
                pre.right.left = null;
            }
        }

        return ans;
    }

    // 4. Divide and Conquer
    // time: O(N)
    // space: O(N)
    public List<Integer> inorder4(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        List<Integer> left = inorder4(root.left);
        List<Integer> right = inorder4(root.right);

        ans.addAll(left);
        ans.add(root.val);
        ans.addAll(right);

        return ans;
    }

    // 5. DFS + stack 死记的版本 检查条件跳回 ***
}
