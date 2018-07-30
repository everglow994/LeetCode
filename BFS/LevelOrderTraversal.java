package BFS;

import BinaryTree.ConvertBSTToDoublyLinkedList.TreeNode;

import java.util.*;

public class LevelOrderTraversal {

    // top to bottom
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }

    // bottom to top:
    public List<List<Integer>> levelOrderII(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(levelList);
        }
        Collections.reverse(result);
        return result;
    }

    // dfs alternative:
    public List<List<Integer>> levelOrderIII(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        helper(root, 1, result);
        return result;
    }

    private void helper(TreeNode root,
                        int level,
                        List<List<Integer>> result) {
        if(root == null) {
            return;
        }

        if(level > result.size()) {
            result.add(new ArrayList<>());
        }
        List<Integer> levelList = result.get(level - 1);
        levelList.add(root.val);
        helper(root.left, level + 1, result);
        helper(root.right, level + 1, result);
    }
}
