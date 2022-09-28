package leecode100;

import java.util.Stack;

/**
 * @author sven
 * @date 2022/09/01
 * @desprication  394. Decode String
 */
public class DecodeString {

    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     *
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     *
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     *
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/decode-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != ']') {
                stack.push(c);
            } else {
                // 取出所有的字符，
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
                    sb.insert(0, stack.pop());
                }
                String sub = sb.toString();
                stack.pop();
                // 取count
                StringBuilder sb2 = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sb2.insert(0, stack.pop());
                }
                int count = Integer.valueOf(sb2.toString());
                while (count > 0) {
                    for (char ch : sub.toCharArray()) {
                        stack.push(ch);
                    }
                    count--;
                }
            }
        }
        StringBuilder retv = new StringBuilder();
        while(!stack.isEmpty())
            retv.insert(0, stack.pop());

        return retv.toString();
    }
}
