import java.util.LinkedList;
import java.util.List;

public class Q6 {
    private static List<List<Integer>> res = new LinkedList<>();
    private static LinkedList<Integer> path = new LinkedList<>();
    private static void backtrack(int[] nums, int start) {
        res.add(new LinkedList<>(path));
        for(int i = start; i < nums.length; i++) {
            path.addLast(nums[i]);
            backtrack(nums, i + 1);
            path.removeLast();
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }
}
