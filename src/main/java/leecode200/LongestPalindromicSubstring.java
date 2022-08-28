package leecode200;

/**
 * @author xixibb
 * @date 2022/08/28
 * @desprication 5. Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 示例 1：
     *
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     *
     * 输入：s = "cbbd"
     * 输出："bb"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxlen = 0;
        int begin = 0;
        char[] chars = s.toCharArray();
        for (int i=0; i < len-1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxlen && isPalindrome(chars, i, j)) {
                    maxlen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxlen);
    }

    private boolean isPalindrome(char[] chars, int left, int right) {
        while(left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }
}
