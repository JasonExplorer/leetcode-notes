package leecode200;

/**
 * @author xixibb
 * @date 2022/08/19
 * @description 53. Maximum Subarray (Easy)
 */
public class MaximumSubarray {

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组 是数组中的一个连续部分。
     *
     * 示例 1：
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6
     *
     * 示例 2：
     * 输入：nums = [1]
     * 输出：1
     *
     * 示例 3：
     * 输入：nums = [5,4,-1,7,8]
     * 输出：23
     *
     */
    public int maxSubarray(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preSum = nums[0];
        int maxSum = preSum;
        for (int i = 1; i < nums.length; i++) {
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }
}
