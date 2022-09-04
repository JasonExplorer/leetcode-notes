
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

    /**
     动态规划：
     解法二中。对于每一列，我们求它左边最高的墙和右边最高的墙，都是重新遍历一遍所有高度，这里我们可以优化一下。
     首先用两个数组，max_left [i] 代表第 i 列左边最高的墙的高度，max_right[i] 代表第 i 列右边最高的墙的高度。
     对于 max_left我们其实可以这样求。

     max_left [i] = Max(max_left [i-1],height[i-1])。它前边的墙的左边的最高高度和它前边的墙的高度选一个较大的，就是当前列左边最高的墙了。

     */
    public int trap3(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int sum = 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        // 求第i个位置左边的边界长度
        for (int i = 1; i < height.length -1; i++) {
            maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
        }

        // 求第i个位置右边的边界长度
        for (int i = height.length -2; i >=0; i--) {
            maxRight[i] = Math.max(maxRight[i+1], height[i+1]);
        }

        for (int i = 1; i < height.length -1 ; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                sum += (min - height[i]);
            }
        }

        return sum;
    }



}
