package BinaryTree;

public class InorderSuccessor {

    // 1. O(N) space:
    //public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    //    if(root == null || p == null) {
    //        return null;
    //    }
    //    Stack<TreeNode> stack = new Stack();
    //    Map<TreeNode, TreeNode> map = new HashMap();
    //
    //    TreeNode cur = root;
    //    TreeNode prev = null;
    //
    //    while(!stack.isEmpty() || cur != null) {
    //        if(cur != null) {
    //            stack.push(cur);
    //            cur = cur.left;
    //        } else {
    //            cur = stack.pop();
    //            if(prev != null) {
    //                map.put(prev, cur);
    //            }
    //            prev = cur;
    //            cur = cur.right;
    //        }
    //    }
    //
    //    return map.getOrDefault(p, null);
    //}
}
