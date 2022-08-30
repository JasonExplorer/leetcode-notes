package leecode200;

/**
 * @author xixibb
 * @date 2022/08/30
 * @desprication 221. Maximal Square
 */
public class MaximalSquare {


    /**
     * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     */
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length ==0 || matrix[0].length== 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        // 对于每个位置(i,j) 检查在矩阵中该位置的值
        // 如果为0，则跳过
        // 如果为1，则 {dp}(i, j)dp(i,j) 的值由其上方、左方和左上方的三个相邻位置的 {dp}dp 值决定。具体而言，当前位置的元素值等于三个相邻位置的元素中的最小值加 11，状态转移方程如下：
        // dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
        for (int i=0; i <rows; i++) {
            for (int j=0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    if (i== 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }

            }
        }
        return maxSide * maxSide;

    }
}
