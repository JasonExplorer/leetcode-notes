package leecode100;

/**
 * @author xixibb
 * @date 2022/08/30
 * @desprication 300. Longest Increasing Subsequence
 */
public class LongestIncreasingSubsequence {

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     *
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-increasing-subsequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxSub = 1;
        int[] dp = new int[nums.length];
        dp[0] =1;
        for (int i=1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxSub = Math.max(maxSub, dp[i]);
        }
        return maxSub;
    }
}
