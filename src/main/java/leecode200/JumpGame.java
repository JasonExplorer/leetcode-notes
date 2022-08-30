package leecode200;

/**
 * @author xixibb
 * @date 2022/08/30
 * @desprication 55. Jump Game
 */
public class JumpGame {


    // 贪心的思想，计算没有能跳跃的最大距离
    public boolean canJump(int[] nums) {

        int n = nums.length;
        int rightmost = 0;
        for (int i =0 ; i < n; i++) {
            if (i<= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
            }
            if (rightmost >= n-1) {
                return true;
            }

        }
        return false;
    }
}
