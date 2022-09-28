package leecode100;

/**
 * @author xixibb
 * @date 2022/08/30
 * @desprication 152. Maximum Product Subarray
 */
public class MaximumProductSubarray {


    public int maxProduct(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        int ans = nums[0];
        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];
        for (int i=1; i< nums.length; i++) {
            maxDp[i] = Math.max(nums[i], Math.max(maxDp[i-1]* nums[i], minDp[i-1]*nums[i]));
            minDp[i] = Math.min(nums[i], Math.min(maxDp[i-1]* nums[i], minDp[i-1]*nums[i]));
            ans = Math.max(ans, maxDp[i]);
        }

        return ans;
    }
}
