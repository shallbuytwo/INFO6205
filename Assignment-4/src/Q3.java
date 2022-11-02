public class Q3 {
    private static boolean validNode(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return validNode(root.left, min, root) && validNode(root.right, root, max);
    }
    public static boolean isValidBST(TreeNode root) {
        return validNode(root, null, null);

    }
}
