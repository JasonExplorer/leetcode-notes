package leecode100;

/**
 * @author sven
 * @date 2022/09/12
 * @desprication 85. Maximal Rectangle
 */
public class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {

        int rowLen = matrix.length;
        if (rowLen == 0) {
            return 0;
        }
        int colLen = matrix[0].length;
        int[][] left = new int[rowLen][colLen];

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (matrix[row][col] == '1') {
                    left[row][col] = (col == 0 ? 0 : left[row][col - 1]) + 1;
                }
            }
        }

        int ret = 0;
        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (matrix[row][col] == '0') {
                    continue;
                }
                int width = left[row][col];
                int area = width;
                for (int k = row - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][col]);
                    area = Math.max(area, (row - k + 1) * width);
                }
                ret = Math.max(ret, area);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        int result = maximalRectangle(matrix);
        System.out.println(result);
    }
}
