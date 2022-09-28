package leecode100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xixibb
 * @date 2022/08/19
 * @desprication 763. Partition Labels (Medium)
 */
public class PartitionLabels {

    /**
     * 763. 划分字母区间
     *
     * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
     *
     * 示例：
     * 输入：S = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/partition-labels
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     */
    public List<Integer> partitionLabels(String s) {

        // 贪心的思想，同一个字符只能出现在同一个片段一次，寻找每个字符最后一次出现的下标位置
        // 字符第一次出现和最后一次出现必然在同一个片段
        int[] lastIndexOfChar = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndexOfChar[char2Index(s.charAt(i))] = i;
        }

        List<Integer> partitions = new ArrayList<>();

        // 第一个片段的首位置默认0
        int firstIndex = 0;
        while (firstIndex < s.length()) {

            int lastIndex = firstIndex;
            for (int i = firstIndex; i< s.length() && i<=lastIndex; i++) {
                // 当前字符最后一次出现的位置
                int index = lastIndexOfChar[char2Index(s.charAt(i))];
                if (index > lastIndex) {
                    lastIndex = index;
                }
            }
            partitions.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return partitions;
    }

    private int char2Index(char c) {
        return c - 'a';
    }
}
