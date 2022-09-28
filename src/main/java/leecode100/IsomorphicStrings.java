package leecode100;

/**
 * @author xixibb
 * @date 2022/08/24
 * @desprication 205. Isomorphic Strings (Easy)
 */
public class IsomorphicStrings {

    /**
     * 205. 同构字符串
     *
     * 给定两个字符串s和t，判断它们是否是同构的。
     *
     * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
     *
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     *
     * 示例 1:
     * 输入：s = "egg", t = "add"
     * 输出：true
     *
     * 输入：s = "foo", t = "bar"
     * 输出：false
     *
     * 输入：s = "paper", t = "title"
     * 输出：true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/isomorphic-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isIsomorphic(String s, String t) {

        // 记录一个字符上次出现的位置，如果两个字符上次出现的位置一样，就属于同构
        int[] preIndexOfs = new int[256];
        int[] preIndexOft = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (preIndexOfs[sc] != preIndexOft[tc]) {
                return false;
            }
            preIndexOfs[sc] = i + 1;
            preIndexOft[tc] = i + 1;
        }
        return true;
    }
}
