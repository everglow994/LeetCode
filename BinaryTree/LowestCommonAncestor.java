package BinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class LowestCommonAncestor {

    // Lowest Common Ancestor of Binary Tree(Medium)

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    // method 1: record parents

    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) {
            return null;
        }

        Map<TreeNode, TreeNode> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        map.put(root, null);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                stack.push(node.left);
                map.put(node.left, node);
            }
            if(node.right != null) {
                stack.push(node.right);
                map.put(node.right, node);
            }
        }

        HashSet<TreeNode> set = new HashSet<>();
        while(map.containsKey(p)) {
            set.add(map.get(p));
            p = map.get(p);
        }

        while(!set.contains(q)) {
            q = map.get(q);
        }

        return q;
    }
}
