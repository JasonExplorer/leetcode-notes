package leecode200;

/**
 * @author xixibb
 * @date 2022/08/19
 * @desprication 540. Single Element in a Sorted Array (Medium)
 */
public class SingleElementInASortedArray {

    /**
     * 给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。
     *
     * 请你找出并返回只出现一次的那个数。
     *
     * 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。
     *
     * 示例 1:
     * 输入: nums = [1,1,2,3,3,4,4,8,8]
     * 输出: 2
     *
     * 输入: nums =  [3,3,7,7,10,11,11]
     * 输出: 10
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/single-element-in-a-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    public int singleNonDuplicate(int[] nums) {

        int left = 0 , right = nums.length -1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                left = mid +2;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
