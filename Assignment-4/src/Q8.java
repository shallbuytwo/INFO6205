public class Q8 {
    private static int res = 0;
    private static void dfs(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }
        if(node.val >= low && node.val <= high) {
            res += node.val;
        }
        if(node.val > low) {
            dfs(node.left,low, high);
        }
        if(node.val < high) {
            dfs(node.right, low, high);
        }
    }

    public static int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        dfs(root, low, high);
        return res;

    }
}
