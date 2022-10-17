import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Q1
        {
            int[] candidates = {2, 3, 6, 7};
            List<List<Integer>> res = Q1.combinationSum(candidates, 7);
            for (List<Integer> l : res) {
                for (Integer i : l) {
                    System.out.print(i);
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        // Q2
        {
            int[] nums = {1, 2, 3};
            List<List<Integer>> res = Q2.permute(nums);
            for (List<Integer> l : res) {
                for (Integer i : l) {
                    System.out.print(i);
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();

        }
        // Q3
        {
            String digits = "23";
            List<String> res = Q3.letterCombinations(digits);
            for (String s: res) {
                System.out.print(s);
                System.out.print(" ");
            }
            System.out.println();
            System.out.println();
        }
        // Q4
        {
            char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
            String word = "ABCCED";
            System.out.print(Q4.exist(board, word));
            System.out.println();
            System.out.println();
        }
        // Q5
        {
            int n = 3;
            int k = 7;
            int [] res = Q5.numsSameConsecDiff(n, k);
            for (int i : res) {
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
            System.out.println();
        }
        // Q6
        {
            int[] nums = {1, 2, 3};
            List<List<Integer>> res = Q6.subsets(nums);

            for (List<Integer> l : res) {
                if (l.isEmpty()) {
                    System.out.println("Empty List");
                    continue;
                }
                for (Integer i : l) {
                    System.out.print(i);
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println();
        }
        // Q7
        {
            int n = 3;
            List<String> res = Q7.generateParenthesis(n);
            for (String r : res) {
                System.out.print(r);
                System.out.print(" ");
            }
        }

    }

}