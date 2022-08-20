package leecode200;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xixibb
 * @date 2022/08/20
 * @description 95. Unique Binary Search Trees II (Medium)
 */
public class UniqueBinarySearchTreesII {

    /**
     * 95. 不同的二叉搜索树 II
     *
     * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
     *
     * 输入：n = 3
     * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
     *
     * 输入：n = 1
     * 输出：[[1]]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/unique-binary-search-trees-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    public List<TreeNode> generateTrees(int n) {

        //二叉搜索树关键的性质是根节点的值大于左子树所有节点的值，小于右子树所有节点的值，且左子树和右子树也同样为二叉搜索树。
        // 在生成所有可行的二叉搜索树的时候，假设当前的序列长度n, 如果我们枚举根节点的值为i, 那么左子树节点集合值，[1…i−1]，
        // 右子树节点值的集合为 [i+1...n]
        if (n < 1) {
            return new ArrayList<>();
        }
        return generateSubTrees(1, n);
    }

    private List<TreeNode> generateSubTrees(int start, int end) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (start > end) {
            treeNodes.add(null);
            return treeNodes;
        }
        for (int i = start; i<=end; i++) {
            List<TreeNode> leftSubTrees = generateSubTrees(start, i-1);
            List<TreeNode> rightSubTrees = generateSubTrees(i+1, end);
            for (TreeNode left : leftSubTrees) {
                for (TreeNode right : rightSubTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    treeNodes.add(root);
                }

            }
        }
        return treeNodes;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


}
