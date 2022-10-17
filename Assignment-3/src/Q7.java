import java.util.ArrayList;
import java.util.List;

public class Q7 {
    private static List<String> res = new ArrayList<>();
    private static void backtrack(int l, int r, StringBuilder path) {
        if (r < l) {
            return;
        }
        if(l < 0 || r < 0) {
            return;
        }
        if(l == 0 && r == 0) {
            res.add(path.toString());
            return;
        }
        path.append("(");
        backtrack(l - 1, r, path);
        path.deleteCharAt(path.length()-1);
        path.append(")");
        backtrack(l, r - 1, path);
        path.deleteCharAt(path.length()-1);
    }
    public static List<String> generateParenthesis(int n) {
        if (n == 0) {
            return res;
        }
        backtrack(n, n, new StringBuilder());
        return res;
    }
}
