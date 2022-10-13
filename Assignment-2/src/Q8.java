import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q8 {
    private Map<Integer, ArrayList> ans = new HashMap();
    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        int level = Math.max(left, right);
        if(!ans.containsKey(level)) {
            ans.put(level, new ArrayList<Integer>());
        }
        ans.get(level).add(root.val);
        return level + 1;

    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        dfs(root);
        List<List<Integer>> res = new ArrayList();
        List<Integer> Keys = new ArrayList<Integer>(ans.keySet());
        for(int k:Keys) {
            res.add(ans.get(k));
        }
        return res;

    }
}
