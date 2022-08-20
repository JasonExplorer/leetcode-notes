package leecode200;

/**
 * @author xixibb
 * @date 2022/08/19
 * @desprication 34. Find First and Last Position of Element in Sorted Array
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     *
     * 你必须设计并实现时间复杂度为O(log n)的算法解决此问题。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     */
    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int firstPosition = findFirstPosition(nums, target);
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }

        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    private int findFirstPosition(int[] nums, int target) {

        int left = 0;
        int right = nums.length -1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid;
            } else {
                right = mid -1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }


    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while (left < right) {
            int mid = left + (right - left + 1)/2;
            if (nums[mid] < target) {
                // 下一轮搜索的区间 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] == target) {
                // 下一轮搜索的区间 [mid, right]
                left = mid;
            } else {
                // 下一轮搜索的区间 [left, mid -1]
                right = mid -1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
