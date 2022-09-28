package leecode100;

/**
 * @author xixibb
 * @date 2022/08/19
 * @description 665. Non-decreasing Array (Easy)
 */
public class NonDecreasingArray {

    /**
     * 给你一个长度为n的整数数组nums，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。
     *
     * 我们是这样定义一个非递减数列的：对于数组中任意的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
     *
     * 示例 1:
     * 输入: nums = [4,2,3]
     * 输出: true
     * 解释: 你可以通过把第一个 4 变成 1 来使得它成为一个非递减数列。
     *
     * 示例 2:
     * 输入: nums = [4,2,1]
     * 输出: false
     * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
     */
    public boolean checkPossibility(int[] nums) {

        if (nums.length == 0 ) {
            return false;
        }
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i] > nums[i-1]) {
                continue;
            }
            cnt++;

            // 删除一个元素，判断是删除i-1, 还是删除i
            // 1、当i前面至少有两个元素， 且前一个节点大于当前节点, 那当前节点赋值为nums[i-1]
            if (i-2>=0 && nums[i-2] > nums[i]) {
                nums[i] = nums[i-1];
            } else {
                nums[i-1] = nums[i];
            }
        }
        return cnt < 2;
    }
}
