package leecode200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xixibb
 * @date 2022/08/28
 * @desprication 15. 三数之和
 */
public class ThreeSum {

    /**
     * 15. 三数之和
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> threeSum(int[] nums) {

        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || len < 3) return result;

        for (int i = 0 ; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0  && nums[i] == nums[i-1]) {
                continue;
            }
            int L = i +1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0 ) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L+1]) {
                        L++;
                    }
                    while (L< R && nums[R] == nums[R-1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0){
                    R--;
                }
            }
        }
        return result;
    }


    public List<List<Integer>> threeSum2(int[] nums) {

        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || len < 3) {
            return result;
        }
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i>0 && nums[i] == nums[i -1]) {
                continue;
            }
            for (int j = i+1; j < len -1; j++) {

                if (j> i+1 && nums[j] == nums[j -1]) {
                    continue;
                }
                for (int k = len -1; j < k; k--) {
                    if (nums[k] == nums[k -1]) {
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }

        return result;

    }
}
