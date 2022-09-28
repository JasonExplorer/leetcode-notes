package leecode100;

/**
 * @author xixixbb
 * @date 2022/08/25
 * @desprication 378. Kth Smallest Element in a Sorted Matrix ((Medium))
 */
public class KthSmallestElementInASortedMatrix {


    /**
     * 378. 有序矩阵中第 K 小的元素
     *
     * 给你一个n x n矩阵matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
     * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
     *
     * 你必须找到一个内存复杂度优于O(n2) 的解决方案。
     *
     * 示例 1：
     *
     * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
     * 输出：13
     * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
     * 示例 2：
     *
     * 输入：matrix = [[-5]], k = 1
     * 输出：-5
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/kth-smallest-element-in-a-sorted-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int kthSmallest(int[][] matrix, int k) {

        // 二分查找, 将有序数组整体看成一个有序的数组
        int m = matrix.length, n = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[m-1][n-1];
        while (low <= high) {
            int mid = low + (high - low)/2;
            int cnt = 0;

            // 查找第k小的元素
            for (int i = 0; i < m; i++) {
                for (int j=0; j<n && matrix[i][j] <= mid; j++) {
                    cnt++;
                }
            }
            if (cnt < k) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return low;


        //
    }
}
