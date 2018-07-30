package BinaryTree;

import java.util.Stack;

public class ConvertBSTToDoublyLinkedList {


    public class TreeNode {
       public int val;
       public TreeNode left, right;
       public TreeNode(int val) {
           this.val = val;
           this.left = this.right = null;
       }
   }

   public class DoublyListNode {
       int val;
       DoublyListNode next, prev;
       DoublyListNode(int val) {
           this.val = val;
           this.next = this.prev = null;
       }
   }


   // 1.simple traverse
    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode head = dummy;
        if (root == null) {
            return head.next;
        }

        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                DoublyListNode next = new DoublyListNode(cur.val);
                head.next = next;
                next.prev = head;
                head = next;
                cur = cur.right;
            }
        }

        return dummy.next;
    }

    // 2. Divide and Conquer

    private class ResultType {
        DoublyListNode first, last;

        ResultType(DoublyListNode first, DoublyListNode last) {
            this.first = first;
            this.last = last;
        }
    }

    public DoublyListNode bstToDoublyList1(TreeNode root) {
        // write your code here
        if(root == null) {
            return null;
        }

        return helper(root).first;
    }

    public ResultType helper(TreeNode root) {
        if(root == null) {
            return null;
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        DoublyListNode first, last;
        DoublyListNode node = new DoublyListNode(root.val);

        if(left == null) {
            first = node;
        } else {
            first = left.first;
            left.last.next = node;
            node.prev = left.last;
        }

        if(right == null) {
            last = node;
        } else {
            last = right.last;
            node.next = right.first;
            right.first.prev = node;
        }

        return new ResultType(first, last);
    }


}
