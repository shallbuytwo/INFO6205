import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class Q6 {
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxWidth = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair(root, 1));
        while(!q.isEmpty()) {
            int sz = q.size();
            int start = 0;
            int end = 0;
            for (int i = 0; i < sz; i ++) {
                Pair<TreeNode, Integer> cur = q.poll();
                TreeNode node = cur.getKey();
                int id = cur.getValue();
                if(i == 0) {
                    start = id;
                }
                if(i == sz - 1) {
                    end = id;
                }
                if(node.left != null) {
                    q.offer(new Pair(node.left, id * 2));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right, id * 2 + 1));
                }
            }
            maxWidth = Math.max(maxWidth, end - start + 1);
        }
        return maxWidth;

    }
}
