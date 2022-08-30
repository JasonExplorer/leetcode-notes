package leecode200;

/**
 * @author xixibb
 * @date 2022/08/30
 * @desprication 200. Number of Islands
 */
public class NumberOfIslands {

    /**
     * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int numIslands(char[][] grid) {
        if (grid == null ) {
            return 0;
        }

        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j =0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    // 在深度优先搜索的过程中，每个搜索到的 11 都会被重新标记为 00。
    // 最终岛屿的数量就是我们进行深度优先搜索的次数。
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0||i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
            dfs(grid, i+1, j);
            dfs(grid, i, j+1);
            dfs(grid, i-1, j);
            dfs(grid, i, j-1);
    }
}
