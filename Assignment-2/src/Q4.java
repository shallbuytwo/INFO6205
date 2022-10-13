import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q4 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return res;
        }
        q.offer(root);
        boolean flag = true;
        while(!q.isEmpty()) {
            int sz = q.size();
            LinkedList<Integer> level = new LinkedList<>();
            for(int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (flag) {
                    level.addLast(cur.val);
                }
                else {
                    level.addFirst(cur.val);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add(level);
            flag = !flag;
        }
        return res;
    }
}
