import java.util.LinkedList;
import java.util.List;

public class Q2 {
    private static List<List<Integer>> res = new LinkedList<>();
    private static LinkedList<Integer> path = new LinkedList<>();
    private static boolean[] used;
    private static void backtrack(int[] nums) {
        if(path.size() == nums.length) {
            res.add(new LinkedList(path));
            return;
        }
        for (int i = 0;i < nums.length; i++) {
            if(used[i]) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);
            backtrack(nums);
            used[i] = false;
            path.removeLast();
        }
    }
    public static List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        backtrack(nums);
        return res;

    }
}
