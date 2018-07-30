package BFS;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeBST {

    private class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            this.val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        if(root == null) {
            return result.toString();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.append(node.val + ",");
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        String serialize = result.toString();
        return serialize.substring(0, serialize.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) {
            return null;
        }
        String[] list = data.split(",");
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < list.length; i++) {
            queue.offer(Integer.parseInt(list[i]));
        }
        return construct(queue);
    }

    private TreeNode construct(Queue<Integer> queue) {
        if(queue.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(queue.poll());
        Queue<Integer> smallQ = new LinkedList<>();
        while(!queue.isEmpty() && queue.peek() < root.val) {
            smallQ.offer(queue.poll());
        }

        root.left = construct(smallQ);
        root.right = construct(queue);
        return root;
    }
}
