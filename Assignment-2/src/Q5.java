import javafx.util.Pair;

import java.util.*;

public class Q5 {
    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) {
            return res;
        }
        Map<Integer, ArrayList> mp = new HashMap();
        Queue<Pair<TreeNode, Integer>> q = new ArrayDeque();
        int column = 0;
        q.offer(new Pair(root, column));

        while(!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode node = p.getKey();
            column = p.getValue();
            if(node != null) {
                if (!mp.containsKey(column)) {
                    mp.put(column, new ArrayList<Integer>());
                }
                mp.get(column).add(node.val);
                q.offer(new Pair(node.left, column - 1));
                q.offer(new Pair(node.right, column + 1));
            }
        }
        List<Integer> sortedKeys = new ArrayList<Integer>(mp.keySet());
        Collections.sort(sortedKeys);
        for(int k:sortedKeys) {
            res.add(mp.get(k));
        }
        return res;
    }
}
