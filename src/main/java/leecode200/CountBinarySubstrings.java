package leecode200;

/**
 * @author xixibb
 * @date 2022/08/24
 * @desprication 696. Count Binary Substrings (Easy)
 */
public class CountBinarySubstrings {

    /**
     * 696. 计数二进制子串
     * 给定一个字符串s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
     *
     * 重复出现（不同位置）的子串也要统计它们出现的次数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/count-binary-substrings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int countBinarySubstrings(String s) {

        int prelen = 0,  curlen = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i -1)) {
                curlen++;
            } else {
                prelen = curlen;
                curlen = 1;
            }
            if (prelen >= curlen) {
                count++;
            }
        }
        return count;
    }
}
