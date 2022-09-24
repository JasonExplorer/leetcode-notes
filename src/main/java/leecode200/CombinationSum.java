package leecode200;

import java.util.LinkedList;
import java.util.List;

/**
 * @author xxbb
 * @date 2022/09/24
 * @desprication 39. Combination Sum
 */
public class CombinationSum {

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        backtrack(candidates, 0, target, 0);
        return res;
    }

    LinkedList<Integer> track = new LinkedList<>();

    private void backtrack(int[] candidates, int start, int target, int sum) {
        if (sum == target) {
            res.add(new LinkedList<>(track));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            track.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, i, target, sum);
            track.removeLast();
        }
    }
}
