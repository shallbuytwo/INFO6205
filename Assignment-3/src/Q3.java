import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q3 {
    private static Map<Character, String> dic = new HashMap() {
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
    };
    private static List<String> res = new ArrayList<>();
    private static void backtrack(StringBuilder sb, int i, String digits, List<String> res, Map<Character, String> dic) {
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char digit = digits.charAt(i);
        String options = dic.get(digit);
        for(char option : options.toCharArray()) {
            sb.append(option);
            backtrack(sb, i + 1, digits, res, dic);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        backtrack(sb, 0, digits, res, dic);
        return res;
    }
}
