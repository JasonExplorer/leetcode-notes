package leecode100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xixibb
 * @date 2020/08/30
 * @desprication 56. Merge Intervals
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> meged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (meged.size() == 0 || meged.get(meged.size() - 1)[1] < left) {
                meged.add(new int[]{left, right});
            } else {
                meged.get(meged.size() - 1)[1] = Math.max(meged.get(meged.size() - 1)[1], right);
            }
        }
        return meged.toArray(new int[meged.size()][]);
    }
}
