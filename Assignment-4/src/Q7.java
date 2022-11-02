public class Q7 {
    private static TreeNode successor;
    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        while(root != null) {
            if (p.val >= root.val) {
                root = root.right;
            }
            else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }
}
