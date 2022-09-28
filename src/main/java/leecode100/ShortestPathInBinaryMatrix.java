package leecode100;



import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;


/**
 * @author xixibb
 * @date 2022/08/26
 * @desprication 1091. Shortest Path in Binary Matrix(Medium)
 */
public class ShortestPathInBinaryMatrix {

    /**
     * 1091. 二进制矩阵中的最短路径
     * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
     *
     * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
     *
     * 路径途经的所有单元格都的值都是 0 。
     * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
     * 畅通路径的长度 是该路径途经的单元格总数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/shortest-path-in-binary-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int shortestPathBinaryMatrix(int[][] grids) {

        if (grids == null || grids.length == 0 || grids[0].length == 0) {
            return -1;
        }
        int[][] direction = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
        int m = grids.length, n = grids[0].length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            pathLength++;
            while (size-- > 0) {
                Pair<Integer, Integer> cur = queue.poll();
                int cr = cur.getKey(), cc = cur.getValue();
                if (grids[cr][cc] == 1) {
                    continue;
                }
                if (cr == m -1 && cc == n -1) {
                    return pathLength;
                }
                grids[cr][cc] = 1;
                for (int[] d: direction) {
                    int nr = cr + d[0], nc = cc + d[1];
                    if (nr < 0 || nr >=m || nc >= n) {
                        continue;
                    }
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }

        return -1;
    }
}
