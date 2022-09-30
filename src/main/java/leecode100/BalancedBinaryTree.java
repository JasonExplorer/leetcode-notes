package leecode100;

import common.TreeNode;

/**
 * @author xxbb
 * @date 2022/09/30
 * @despriaction 110. Balanced Binary Tree (Easy)
 */
public class BalancedBinaryTree {

    private boolean result = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return result;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (Math.abs(left - right) > 1) {
            result = false;
        }
        return Math.max(left, right) + 1;
    }
}
