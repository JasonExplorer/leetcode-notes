package leecode100;

/**
 * @author xixibb
 * @date 2022/08/25
 * @desprication 645. Set Mismatch (Easy)
 */
public class SetMismatch {

    /**
     * 645. 错误的集合
     * 集合 s 包含从 1 到n的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
     *
     * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
     *
     * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,2,4]
     * 输出：[2,3]
     * 示例 2：
     *
     * 输入：nums = [1,1]
     * 输出：[1,2]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/set-mismatch
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] findErrorNums(int[] nums) {

        // 对数组进行排序, 对排序后的数组遍历然后返回结果
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i+1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i <= nums.length; i++) {
            if (nums[i] != i +1) {
                return new int[]{nums[i], i+1};
            }
        }
        return null;
    }

    // 将num[i]和nums[j]的位置互换
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
