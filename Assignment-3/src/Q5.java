import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Q5 {
    private static List<Integer> res = new ArrayList<>();
    private static void dfs(int n, int num, int k, List<Integer> res) {
        if(n == 0) {
            res.add(num);
            return;
        }
        HashSet<Integer> nextDigits = new HashSet<>();
        Integer tailDigit = num % 10;
        nextDigits.add(tailDigit + k);
        nextDigits.add(tailDigit - k);
        for(Integer nextDigit:nextDigits) {
            if(0 <= nextDigit && nextDigit < 10) {
                Integer newNum = num * 10 + nextDigit;
                dfs(n - 1, newNum, k, res);
            }
        }
    }
    public static int[] numsSameConsecDiff(int n, int k) {
        if(n == 1) {
            return new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        }
        for(int num = 1; num < 10; num++) {
            dfs(n - 1, num, k, res);
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}
