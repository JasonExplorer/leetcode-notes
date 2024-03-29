package leecode100;

/**
 * @author xixibb
 * @date 2022/08/24
 * @desprication 409. Longest Palindrome (Easy)
 */
public class LongestPalindrome {

    /**
     * 409. 最长回文串
     * 给定一个包含大写字母和小写字母的字符串s，返回通过这些字母构造成的最长的回文串。
     *
     * 在构造过程中，请注意 区分大小写 。比如"Aa"不能当做一个回文字符串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/longest-palindrome
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    public int longestPalindrome(String s) {
        int[] cnts = new int[256];
        for (char c : s.toCharArray()) {
            cnts[c]++;
        }

        int palindrome = 0;
        for (int cnt : cnts) {
            palindrome += (cnt/2) *2;
        }

        if (palindrome < s.length()) {
            palindrome++;
        }
        return palindrome;
    }
}
