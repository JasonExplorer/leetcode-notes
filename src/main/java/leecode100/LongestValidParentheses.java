package leecode100;

import java.util.Stack;

/**
 * @author sven
 * @date 2022/09/05
 * @desprication 32. Longest Valid Parentheses
 */
public class LongestValidParentheses {


    public int longestValidParentheses1(String s) {
        Stack<Integer> stack = new Stack<>();
        int[] dp = new int[s.length() + 1];
        for (int i=0; i< s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                dp[i+1] =0;
            } else {
                if (!stack.isEmpty()) {
                    int leftIndex = stack.pop();
                    int len = i - leftIndex + dp[leftIndex] + 1;
                    dp[i+1] = len;
                } else {
                    dp[i+1] = 0;
                }
            }
        }

        int res = 0;
        for (int i=0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;

    }
}
