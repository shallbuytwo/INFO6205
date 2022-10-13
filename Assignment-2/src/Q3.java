import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q3 {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while(!que.isEmpty()) {
            int sz = que.size();
            TreeNode last = que.peek();
            for(int i = 0; i < sz; i ++) {
                TreeNode cur = que.poll();
                if (cur.right != null) {
                    que.offer(cur.right);
                }
                if (cur.left != null) {
                    que.offer(cur.left);
                }
            }res.add(last.val);
        }
        return res;
    }
}
