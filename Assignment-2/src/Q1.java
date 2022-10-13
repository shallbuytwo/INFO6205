public class Q1 {
    private static boolean isMirror(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) {
            return true;
        }
        else if (p1 == null || p2 == null) {
            return false;
        }
        else if (p1.val != p2.val) {
            return false;
        }
        return isMirror(p1.left, p2.right) && isMirror(p1.right, p2.left);
    }
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }
}
