import java.util.HashSet;

public class Q4 {
    private static boolean dfs(char[][] board, int i, int j, String word, int index, HashSet<Integer> visited) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        visited.add(i * col + j);
        if (i - 1 >= 0 && !visited.contains((i - 1) * col + j)) {
            if (dfs(board, i - 1, j, word, index + 1, visited)) return true;
        }
        if (i + 1 < row && !visited.contains((i + 1) * col + j)) {
            if (dfs(board, i + 1, j, word, index + 1, visited)) return true;
        }
        if (j - 1 >= 0 && !visited.contains(i * col + j - 1)) {
            if (dfs(board, i, j - 1, word, index + 1, visited)) return true;
        }
        if (j + 1 < col && !visited.contains(i * col + j + 1)) {
            if (dfs(board, i, j + 1, word, index + 1, visited)) return true;
        }
        visited.remove(i * col + j);
        return false;
    }

    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                HashSet<Integer> st = new HashSet<>();
                if (dfs(board, i, j, word, 0, st)) {
                    return true;
                }
            }
        }

        return false;
    }
}
