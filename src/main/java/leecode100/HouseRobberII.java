package leecode100;

import java.util.Arrays;

/**
 * @author sven
 * @date 2022/09/02
 * @desprication 213. House Robber II
 */
public class HouseRobberII {

    public int rob(int[] nums) {
        if (nums== null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] m1 = new int[nums.length];
        int[] m2 = new int[nums.length];
        Arrays.fill(m1, -1);
        Arrays.fill(m2, -1);

        return Math.max(
                dfs(nums, 0, nums.length -2, m1),
                dfs(nums, 1, nums.length -1, m2));
    }

    int dfs(int[] nums, int start, int end, int[] m) {
        if (start > end) {
            return 0;
        }
        if (m[start] != -1) {
            return m[start];
        }
        int res = Math.max(
                dfs(nums, start + 2, end, m) + nums[start],
                dfs(nums, start + 1, end, m));
        m[start] = res;
        return res;
    }
}
