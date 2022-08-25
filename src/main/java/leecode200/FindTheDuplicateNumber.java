package leecode200;

/**
 * @author xixibb
 * @date 2022/08/25
 * @despricaiton 287. Find the Duplicate Number (Medium)
 */
public class FindTheDuplicateNumber {


    /**
     * 287. 寻找重复数
     *
     * 给定一个包含n + 1 个整数的数组nums ，其数字都在[1, n]范围内（包括 1 和 n），可知至少存在一个重复的整数。
     *
     * 假设 nums 只有 一个重复的整数 ，返回这个重复的数 。
     *
     * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
     *
     * 示例 1：
     *
     * 输入：nums = [1,3,4,2,2]
     * 输出：2
     * 示例 2：
     *
     * 输入：nums = [3,1,3,4,2]
     * 输出：3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-the-duplicate-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int findDuplicate(int[] nums) {

        // 快慢指针方法, 3个步骤
        // 1、定义快慢指针 slow, fast
        // 2、第一次相遇，说明存在环， 设置fast指针为0
        // 3、第二次相遇，找到环的入口，重复数
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
