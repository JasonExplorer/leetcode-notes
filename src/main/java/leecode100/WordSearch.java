package leecode100;

/**
 * @author xixibb
 * @date 2022/08/30
 * @desprication 79. Word Search
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j,  int k) {
        if (k == word.length()) {
            return true;
        }

        if (i <0 || j < 0 || i>=board.length || j >= board[0].length) {
            return false;
        }

        if (word.charAt(k) != board[i][j]) {
            return false;
        }
        char t = board[i][j];
        board[i][j] = '0';
        boolean res = dfs(board, word, i+1, j, k +1)
                || dfs(board, word, i-1, j, k +1)
                || dfs(board, word, i, j+1,k+1)
                || dfs(board, word, i, j -1, k+1);
        board[i][j] = t;
        return res;
    }
}
