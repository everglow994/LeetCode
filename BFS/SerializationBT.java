package BFS;



import java.util.LinkedList;
import java.util.Queue;

public class SerializationBT {

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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    result.append("#,");
                } else {
                    result.append(node.val + ",");
                }
                if(node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
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
        Queue<TreeNode> queue = new LinkedList<>();

        int cur = 0;
        TreeNode root = constructNode(list, cur++);
        queue.offer(root);

        while(!queue.isEmpty() && cur < list.length) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                node.left = constructNode(list, cur++);
                node.right = constructNode(list, cur++);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }

    private TreeNode constructNode(String[] s, int cur) {
        if(s[cur].equals("#")) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(s[cur]));
        }
    }
}
