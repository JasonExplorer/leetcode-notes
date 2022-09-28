package leecode100;

/**
 * @author xixibb
 * @date 2022/08/28
 * @desprication 238. Product of Array Except Self
 */
public class ProductOfArrayExceptSelf {

    /**
     * 238. 除自身以外数组的乘积
     * 给你一个整数数组nums，返回 数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。
     *
     * 题目数据 保证 数组nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。
     *
     * 请不要使用除法，且在O(n) 时间复杂度内完成此题。
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     * 示例 2:
     *
     * 输入: nums = [-1,1,0,-3,3]
     * 输出: [0,0,9,0,0]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/product-of-array-except-self
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] productExceptSelf(int[] nums) {

        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];

        int[] result = new int[len];
        L[0] = 1;
        for (int i = 1; i< len; i++) {
            L[i] = L[i-1] * nums[i-1];
        }

        R[len -1] = 1;
        for (int i = len -2; i >= 0; i--) {
            R[i] = nums[i+1] * R[i+1];
        }
        for (int i =0; i < len; i++) {
            result[i] = L[i] * R[i];
        }
        return result;
    }
}
