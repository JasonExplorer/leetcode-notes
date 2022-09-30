package leecode100;

import common.TreeNode;

/**
 * @author xxbb
 * @date 2022/09/30
 * @desprication 226. Invert Binary Tree (Easy)
 */
public class InvertBinaryTree {


    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        traverse(root.left);
        traverse(root.right);
    }
}
