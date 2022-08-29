package leecode200;

import common.TreeNode;

/**
 * @author xixibb
 * @date 2022/08/29
 * @desprication 538. Convert BST to Greater Tree
 */
public class ConvertBSTToGreaterTree {

    // 反中根序遍历
    int sum =0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
