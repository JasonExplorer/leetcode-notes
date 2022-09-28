package leecode100;

import common.TreeNode;

/**
 * @author xixibb
 * @date 2022/08/29
 * @desprication 337. House Robber III
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] L = dfs(node.left);
        int[] R = dfs(node.right);
        int selected = node.val + L[1] + R[1];
        int noSelected = Math.max(L[0], L[1]) + Math.max(R[0], R[1]);
        return new int[]{selected, noSelected};
    }

}
