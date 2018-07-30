package BFS;

import BinaryTree.ConvertBSTToDoublyLinkedList.TreeNode;

import java.util.*;

public class ZigZagTraversal {

    // use double stack to bfs
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.push(root);

        while(!stack1.isEmpty() || !stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                int size = stack1.size();
                List<Integer> levelList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = stack1.pop();
                    levelList.add(node.val);
                    if (node.left != null) {
                        stack2.push(node.left);
                    }
                    if (node.right != null) {
                        stack2.push(node.right);
                    }
                }
                result.add(levelList);
            }

            while (!stack2.isEmpty()) {
                int size = stack2.size();
                List<Integer> levelList = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = stack2.pop();
                    levelList.add(node.val);
                    if (node.right!= null) {
                        stack1.push(node.right);
                    }
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                }
                result.add(levelList);
            }


        }
        return result;
    }

    // use queue to bfs
    public List<List<Integer>> zigzagII(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean odd = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if(!odd) {
                Collections.reverse(levelList);
            }
            result.add(levelList);
            odd = !odd;
        }
        return result;
    }


    // use deque
    public List<List<Integer>> zigzagIII(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean odd = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();

            if(odd) {
                for(int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    levelList.add(node.val);
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            } else {
                for(int i = 0; i < size; i++) {
                    TreeNode node = queue.pollLast();
                    levelList.add(node.val);
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                }
            }
            result.add(levelList);
            odd = !odd;
        }
        return result;
    }

}
