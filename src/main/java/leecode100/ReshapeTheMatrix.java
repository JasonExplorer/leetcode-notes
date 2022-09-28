package leecode100;

/**
 * @author xixibb
 * @date 2022/08/24
 * @desprication 566. Reshape the Matrix (Easy)
 */
public class ReshapeTheMatrix {

    /**
     * 566. 重塑矩阵
     *
     * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
     *
     * 给你一个由二维数组 mat 表示的m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
     *
     * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
     *
     * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/reshape-the-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {

        int m = mat.length, n = mat[0].length;
        if (m*n != r*c) {
            return mat;
        }
        int[][] reshapedNums = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j=0; j < c; j++) {
                reshapedNums[i][j] = mat[index/n][index%n];
                index++;
            }
        }
        return reshapedNums;
    }
}
