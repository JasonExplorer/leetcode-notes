package leecode100;

/**
 * @author xixibb
 * @date 2022/08/25
 * @desprication 485. Max Consecutive Ones (Easy)
 */
public class MaxConsecutiveOnes {

    /**
     * 485. 最大连续 1 的个数
     * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,0,1,1,1]
     * 输出：3
     * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
     * 示例 2:
     *
     * 输入：nums = [1,0,1,1,0,1]
     * 输出：2
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/max-consecutive-ones
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max= 0, cur = 0;
        for (int num : nums) {
            if (num == 1) {
                cur++;
            } else {
                cur = 0;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}
