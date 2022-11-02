public class Q4 {
    private static TreeNode first;
    private static TreeNode second;
    private static TreeNode pre = new TreeNode(Integer.MIN_VALUE);
    private static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        if (root.val < pre.val) {
            if (first == null) {
                first = pre;
            }
            second = root;
        }
        pre = root;
        traverse(root.right);

    }
    public static void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }
}
