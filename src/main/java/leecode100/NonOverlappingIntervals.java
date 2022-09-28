package leecode100;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xixibb
 * @date 2022/08/18
 * @desprication 435. Non-overlapping Intervals (Medium)
 */
public class NonOverlappingIntervals {

    /**
     * 435. 无重叠区间
     * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回 需要移除区间的最小数量，使剩余区间互不重叠。
     *
     * 先计算出最多能组成的不重叠的区间个数，然后用区间总数减去不重叠的区间个数
     */
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o-> o[1]));
        int cnt = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                continue;
            }
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length  - cnt;
    }
}
