package leecode100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xixibb
 * @date 2022/09/19
 * @desprication 3. Longest Substring Without Repeating Characters
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0, res = 0;
        for (int right =0; right < s.length(); right++) {
            char c = s.charAt(s.charAt(right));
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            res = Math.max(res, right - left +1);
        }
        return res;

    }
}
