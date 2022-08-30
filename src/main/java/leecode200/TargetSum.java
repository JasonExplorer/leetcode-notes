package leecode200;

/**
 * @author xixibb
 * @date 2022/08/30
 * @desprication 494. Target Sum
 */
public class TargetSum {

    int count = 0;

    /**
     * 给你一个整数数组 nums 和一个整数 target 。
     *
     * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
     *
     * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/target-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int findTargetSumWays(int[] nums, int target) {

        // 思路，回溯的方法
        // 数组nums[]每个元素的前面都可以加+或者-号，因此每个元素都有两种方法，n个元素总共有2n次方添加的方法
        backtrack(nums, target, 0 ,0);
        return count;
    }

    private void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }
}
