package leecode200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xixibb
 * @date 2022/08/23
 * @desprication 128. Longest Consecutive Sequence (Hard)
 */
public class LongestConsecutiveSequence {

    /**
     * 128. 最长连续序列
     *
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     *
     * 请你设计并实现时间复杂度为O(n) 的算法解决此问题。
     *
     * 示例 1：
     *
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     *
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-consecutive-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        // 时间换空间的思想，将数组的元素放到hash表里面
        for (int num : nums) {
            numMap.put(num, 1);
        }

        // 遍历获取每个元素的最长子序列
        for (int num : nums) {
            forward(numMap, num);
        }

        return maxCount(numMap);
    }

    private int forward(Map<Integer, Integer> numMap, int num) {
        // 判空，为空说明不连续结束递归
        if (!numMap.containsKey(num)) {
            return 0;
        }

        // 如果numMap元素大于0， 说明不连续中断处理过了
        int cnt = numMap.get(num);
        if (cnt > 1) {
            return cnt;
        }

        cnt = forward(numMap, num + 1) + 1;
        numMap.put(num, cnt);
        return cnt;
    }

    private int maxCount(Map<Integer, Integer> numMap) {
        int max = 0;
        for (int num : numMap.keySet()) {
            max = Math.max(max, numMap.get(num));
        }
        return max;
    }
}
