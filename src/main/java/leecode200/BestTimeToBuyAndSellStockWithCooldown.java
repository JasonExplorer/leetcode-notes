package leecode200;

/**
 * @author xixibb
 * @date 2022/08/30
 * @desprication 309. Best Time to Buy and Sell Stock with Cooldown
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * 给定一个整数数组prices，其中第prices[i]表示第i天的股票价格 。
     *
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     *
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // dp(i,0) 当日买入，股票最大收益
        // dp(i,1) 当日卖出，股票最大收益
        // dp(i,2) 当日处于冷冻期，股票最大收益
        int[][] dp = new int[n][3];
        // 第1天是负的
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i =1; i < n; i++) {
            // 当天买入
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            // 当天卖出
            dp[i][1] = dp[i-1][0] + prices[i];
            // 当天是冷冻期
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }
        return Math.max(dp[n-1][1], dp[n-1][2]);
    }
}
