package leecode100;

import java.util.Stack;

/**
 * @author xixibb
 * @date 2022/08/23
 * @desprication 20. Valid Parentheses (Easy)
 */
public class ValidParentheses {

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合
     *
     * 示例 1：
     * 输入：s = "()"
     * 输出：true
     *
     * 输入：s = "()[]{}"
     * 输出：true
     *
     * 输入：s = "(]"
     * 输出：false
     *
     * 输入：s = "([)]"
     * 输出：false
     *
     * 输入：s = "{[]}"
     * 输出：true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c=='{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char cStack = stack.pop();
                if ((c == ')' && cStack != '(')
                        || (c == '}' && cStack != '{')
                        || (c == ']' && cStack != '[') ) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
