package leecode200;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xxbb
 * @date 2022/09/24
 * @desprication 46. Permutations
 */
public class Permutations {

    LinkedList<Integer> track = new LinkedList<>();
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used) {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, used);
            track.removeLast();
            used[i] = false;
        }
    }
}
