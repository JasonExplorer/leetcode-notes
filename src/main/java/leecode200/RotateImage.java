package leecode200;

/**
 * @author xixibb
 * @date 2022/08/28
 * @desprication 48. Rotate Image
 */
public class RotateImage {

    /**
     * 48. 旋转图像
     * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     *
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/rotate-image
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param matrix
     */
    public void rotate(int[][] matrix) {

        int n = matrix.length;
        int[][] matrix2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j=0; j < n; j++) {
                matrix2[j][n- i - 1] = matrix[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j=0; j< n; j++) {
                matrix[i][j] = matrix2[i][j];
            }
        }
    }
}
