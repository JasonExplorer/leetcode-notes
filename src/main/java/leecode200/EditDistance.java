package leecode200;

/**
 * @author sven
 * @date 2022/09/04
 * @desprication 72. Edit Distance
 */
public class EditDistance {

    /**
     思路：
     dp[i][j] 表示word1前i个字符和word2前j个字符的最少编辑距离。
     1、如果word1[i-1] === word2[j-1],说明最后一个字符不用操作，此时dp[i][j] = dp[i-1][j-1]，
        即此时的最小操作数和word1和word2都减少一个字符的最小编辑数相同
     2、 如果word1[i-1] !== word2[j-1]，则分为三种情况
        word1删除最后一个字符，状态转移成dp[i-1][j]，即dp[i][j] = dp[i-1][j] + 1，+1指删除操作
        word1在最后加上一个字符，状态转移成dp[i][j-1]，即dp[i][j] = dp[i][j-1] + 1，+1指增加操作
        word1替换最后一个字符，状态转移成dp[i-1][j-1]，即dp[i] [j] = dp[i-1] [j-1] + 1，+1指替换操作
     */
    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        if (m*n == 0) {
            return m+n;
        }
        int[][] dp = new int[n+1][m+1];
        for (int i=0; i< n+1; i++) {
            dp[i][0] = i;
        }
        for (int j=0; j < m+1; j++) {
            dp[0][j] = j;
        }

        for (int i=1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
