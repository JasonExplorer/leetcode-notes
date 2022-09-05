package leecode200;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sven
 * @date 2022/09/05
 * @desprication 76. Minimum Window Substring
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        // 维护两个map记录窗口中符合条件的字符，以及need的字符
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c: t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left =0, right =0;
        //count记录当前窗口中符合need要求的字符的数量,当count == need.size()时即可shrik窗口
        int count = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            //窗口扩大
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    count++;
                }
            }
        }
        //shrink左边界，找符合条件的最优解
        while (count == need.size()) {
            if (right - left < len) {
                len = right - left;
                start = left;
            }
            char d= s.charAt(left);
            left++;
            if (need.containsKey(d)) {
                if (need.get(d).equals(window.get(d))) {
                    count--;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start,start+len);
    }
}
