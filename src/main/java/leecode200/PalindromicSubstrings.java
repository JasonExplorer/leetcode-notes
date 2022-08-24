package leecode200;

/**
 * @author xixibb
 * @date 2022/08/24
 * @desprication 647. Palindromic Substrings (Medium)
 */
public class PalindromicSubstrings {

    /**
     * 647. 回文子串
     *
     * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
     * 回文字符串 是正着读和倒过来读一样的字符串。
     * 子字符串 是字符串中的由连续字符组成的一个序列。
     *
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     *
     * 示例 1：
     * 输入：s = "abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     *
     * 输入：s = "aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/palindromic-substrings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int countSubstrings(String s) {

        // 中心扩散的思想，是找到一个字符作为回文字符串的中心，往两边扩散
        for (int i = 0; i< s.length(); i++) {
            // 奇数长度
            extendSubString(s, i , i);
            // 偶数长度
            extendSubString(s, i , i+1);
        }
        return cnt;
    }

    private int cnt = 0;

    private void extendSubString(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            cnt++;
        }
    }
}
