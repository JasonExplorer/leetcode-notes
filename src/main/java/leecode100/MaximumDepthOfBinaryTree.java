package leecode100;

import common.TreeNode;

/**
 * @author xxbb
 * @date 2022/09/30
 * @desprication Maximum depth of Binary Tree
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
