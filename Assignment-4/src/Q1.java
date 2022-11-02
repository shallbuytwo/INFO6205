public class Q1 {
    private static ListNode cur;
    private static TreeNode inorderBuild(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (right - left) / 2 + left;
        TreeNode leftTree = inorderBuild(left, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode rightTree = inorderBuild(mid + 1, right);
        root.left = leftTree;
        root.right = rightTree;
        return root;
    }
    public static TreeNode sortedListToBST(ListNode head) {
        int len = 0;
        cur = head;
        for(ListNode p = head; p != null; p = p.next) {
            len++;
        }
        return inorderBuild(0, len - 1);

    }
}