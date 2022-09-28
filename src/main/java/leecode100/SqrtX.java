package leecode100;

/**
 * @author xixibb
 * @date 2022/08/19
 * @desprication 69. Sqrt(x) (Easy)
 */
public class SqrtX {

    /**
     * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
     *
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     *
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     *
     * 示例 1：
     * 输入：x = 4
     * 输出：2
     *
     * 示例 2：
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/sqrtx
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        // 一个数x的开方sqrt一定在0~x这个区间，且满足 sqrt = x/sqrt. 可以利用二分查找在0~x 之间sqrt
        int left = 1, right = x;
        while (left <= right) {
            int mid = left + (right - left)/2;
            int sqrt = x/mid;
            if (sqrt == mid) {
                return mid;
            } else if (mid > sqrt) {
                right = mid - left;
            } else {
                left = mid +1;
            }
        }
        return right;
    }
}
