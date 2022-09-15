package leecode200;

import common.TreeNode;

/**
 * @author sven
 * @date 2022/09/02
 * @desprication 124. Binary Tree Maximum Path Sum
 */
public class BinaryTreeMaximumPathSum {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        oneSideMax(root);
        return res;
    }

    private int oneSideMax(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = Math.max(0, oneSideMax(root.left));
        int rightSum = Math.max(0, oneSideMax(root.right));

        int pathMaxSum = root.val + leftSum + rightSum;
        res = Math.max(res, pathMaxSum);
        return Math.max(leftSum, rightSum) + root.val;
    }
}
