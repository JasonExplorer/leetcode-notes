package leecode100;

/**
 * @author xixibb
 * @date 2022/08/27
 * @desprication 70. Climbing Stairs (Easy)
 */
public class ClimbingStairs {

    /**
     * 70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 示例 1：
     *
     * 输入：n = 2
     * 输出：2
     * 解释：有两种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶
     * 2. 2 阶
     * 示例 2：
     *
     * 输入：n = 3
     * 输出：3
     * 解释：有三种方法可以爬到楼顶。
     * 1. 1 阶 + 1 阶 + 1 阶
     * 2. 1 阶 + 2 阶
     * 3. 2 阶 + 1 阶
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int climbStairs(int n) {

        if (n < 2) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i =2; i <n; i++) {
            int third = first + second;
            second = first;
            first = third;
        }
        return first;
    }
}
