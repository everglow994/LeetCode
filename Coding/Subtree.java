package Coding;

public class Subtree {

    class TreeNode {
        int val;
        TreeNode left,right;
        TreeNode(int x) {
            this.val = x;
        }
    }

//    public static boolean isSubTree(TreeNode t1, TreeNode t2) {
//        if(t1 == null)
//            return false;
//        if(t2 == null)
//            return true;
//        return isSameTree(t1, t2) || isSubTree(t1.left, t2) || isSubTree(t1.right, t2);
//    }
//
//    private static boolean isSameTree(TreeNode t1, TreeNode t2) {
//        if(t1 == null && t2 == null) {
//            return true;
//        }
//
//        if(t1 == null || t2 == null) {
//            return false;
//        }
//
//        if(t1.val != t2.val) {
//            return false;
//        }
//        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
//    }



    // version 2
    public static int isSubTree(TreeNode t1, TreeNode t2) {
        if(t1 == null)
            return -1;
        if(t2 == null)
            return 1;
        return (isSameTree(t1, t2) == 1 || isSubTree(t1.left, t2) == 1 || isSubTree(t1.right, t2) == 1) ? 1 : -1;
    }

    private static int isSameTree(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return 1;
        }

        if(t1 == null || t2 == null) {
            return -1;
        }

        if(t1.val != t2.val) {
            return -1;
        }
        return isSameTree(t1.left, t2.left) == 1 && isSameTree(t1.right, t2.right) == 1 ? 1 : -1;
    }
}
