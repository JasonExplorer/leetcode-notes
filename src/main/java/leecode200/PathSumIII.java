package leecode200;

import common.TreeNode;

/**
 * @author sven
 * @date 2022/09/01
 * @despricaiton 437. Path Sum III
 */
public class PathSumIII {

    public int pathSum(TreeNode root, int targetSum) {
        // 暴力解法穷举所有的可能性
        if (root == null) {
            return 0;
        }
        int ret = rootSum(root, targetSum);
        ret += pathSum(root.left, targetSum);
        ret += pathSum(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, int targetSum) {
        int ret = 0;
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }
        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }
}
