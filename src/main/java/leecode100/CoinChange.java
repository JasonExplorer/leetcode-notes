package leecode100;

import java.util.Arrays;

/**
 * @author xixibb
 * @date 2020/08/31
 * @desprication 322. Coin Change
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] =0;
        for (int i=1; i <= amount; i++) {
            for (int j=0; j<coins.length; j++) {
                if (coins[j] < i) {
                    dp[i] = Math.min(dp[i-1], dp[i - coins[i]] +1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
