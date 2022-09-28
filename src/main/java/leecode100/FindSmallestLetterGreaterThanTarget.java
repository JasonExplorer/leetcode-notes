package leecode100;

/**
 * @author xixibb
 * @date 2022/08/19
 * @desprication 744. Find Smallest Letter Greater Than Target (Easy)
 */
public class FindSmallestLetterGreaterThanTarget {

    /**
     * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母target，请你寻找在这一有序列表里比目标字母大的最小字母。
     *
     * 在比较时，字母是依序循环出现的。举个例子：
     *
     * 如果目标字母 target = 'z' 并且字符列表为letters = ['a', 'b']，则答案返回'a'
     *
     * 示例:
     * 输入: letters = ["c", "f", "j"]，target = "a"
     * 输出: "c"
     *
     * 输入: letters = ["c","f","j"], target = "c"
     * 输出: "f"
     *
     * 输入: letters = ["c","f","j"], target = "d"
     * 输出: "f"
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/find-smallest-letter-greater-than-target
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public char nestGreatestLetter(char[] letters, char target) {

        int left = 0, right = letters.length -1;
        while (left<=right) {
            int mid = left + (right - left)/2;
            if (letters[mid]  <= target) {
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return left < letters.length ? letters[left] : letters[0];
    }
}
