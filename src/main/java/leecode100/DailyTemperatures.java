package leecode100;

import java.util.Stack;

/**
 * @author xixibb
 * @date 2022/08/23
 * @despricatiion 739. Daily Temperatures (Medium)
 */
public class DailyTemperatures {

    /**
     * 739. 每日温度
     *
     * 给定一个整数数组temperatures，表示每天的温度，返回一个数组answer，其中answer[i]是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用0 来代替。
     *
     * 示例 1:
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出:[1,1,4,2,1,1,0,0]
     * 示例 2:
     * 输入: temperatures = [30,40,50,60]
     * 输出:[1,1,1,0]
     * 示例 3:
     * 输入: temperatures = [30,60,90]
     * 输出: [1,1,0]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/daily-temperatures
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;
        int[] dist = new int[n];
        Stack<Integer> indexs = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!indexs.isEmpty() && temperatures[i] > temperatures[indexs.peek()]) {
                int preIndex = indexs.pop();
                dist[preIndex] = i - preIndex;
            }
            indexs.add(i);
        }
        return dist;
    }
}
