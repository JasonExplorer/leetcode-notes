
package leecode200;

/**
 * @author sven
 * @date 2022/09/04
 * @desprication 42. Trapping Rain Water
 */
public class TrappingRainWater {

    // 解法1按照行求
    public int trap1(int[] height) {
        int sum = 0;
        // 找到最大的高度
        int max= getMax(height);
        for (int i = 1; i <= max; i++) {
            // 标记是否开始更新 temp
            boolean isStart = false;
            int tempSum = 0;
            for (int j =0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    tempSum++;
                }

                if (height[j] >= i ) {
                    sum += tempSum;
                    tempSum =0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    private int getMax(int[] height) {
        int max = 0;
        for (int i = 0;i < height.length; i++) {
            max = Math.max(0, height[i]);
        }
        return max;
    }

    // 解法2按照列求
    public int trap2(int[] height) {

        int sum = 0;
        for (int i=0; i < height.length; i++) {
            // 找出左边最高的
            int maxLeft = 0;
            for (int j = i-1; j >=0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            // 找出右边最高的
            int maxRight = 0;
            for (int j = i+1; i < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }

            int min = Math.min(maxLeft, maxRight);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }
        return sum;
    }
}
