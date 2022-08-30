package leecode200;

/**
 * @author xixibb
 * @date 2022/08/30
 * @desprication 33. Search in Rotated Sorted Array
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return nums[0] == target ? 0: -1;
        }
        int left = 0, right = len -1;
        while (left < right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            }

            // 二分查找变种， 判断最左边元素和mid元素的大小
            // 1. 最左边元素小于中间元素，说明左边是排列有序的
            // 2. 最左边元素大于中间元素，说明右边是有序的
            if (nums[0] <= nums[mid]) {
                // 左边有序， nums[0] < target< nums[mid]
                if (nums[0] <= target && target < nums[mid]) {
                    right = mid -1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[len-1]) {
                    left = mid +1;
                } else {
                    right = mid -1;
                }
            }
        }
        return -1;
    }
}
