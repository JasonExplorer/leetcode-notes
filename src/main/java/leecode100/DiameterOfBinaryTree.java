package leecode100;

import common.TreeNode;

/**
 * @author xxbb
 * @date 2022/09/30
 * @desprication 543. Diameter of Binary Tree (Easy)
 */
public class DiameterOfBinaryTree {

    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        max = Math.max(max , left + right);
        return Math.max(left, right)  + 1;
    }
}
