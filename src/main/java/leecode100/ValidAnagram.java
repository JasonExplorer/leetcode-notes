package leecode100;

/**
 * @author xixibb
 * @date 2022/08/24
 * @desprication 242. Valid Anagram (Easy)
 */
public class ValidAnagram {

    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     *
     * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-anagram
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isAnagram(String s, String t) {
        int[] cnts = new int[26];
        for (char c : s.toCharArray()) {
            cnts[c - 'a']++;
        }

        for(char c : t.toCharArray()) {
            cnts[c -'a']--;
        }

        for (int cnt : cnts) {
            if (cnt != 0) {
                return false;
            }
        }
        return true;
    }
}
