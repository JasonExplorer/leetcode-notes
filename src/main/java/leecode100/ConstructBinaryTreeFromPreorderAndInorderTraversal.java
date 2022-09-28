package leecode100;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xixibb
 * @date 2022/08/29
 * @desprication 105. Construct Binary Tree from Preorder and Inorder Traversal
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    int index = 0;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        int value = preorder[index];
        index++;
        TreeNode root = new TreeNode(value);
        // 中序遍历， 根节点位置， 左右位置分别为二叉树
        root.left = build(preorder, left, map.get(value) - 1);
        root.right = build(preorder, map.get(value)+ 1, right);
        return root;
    }
}
