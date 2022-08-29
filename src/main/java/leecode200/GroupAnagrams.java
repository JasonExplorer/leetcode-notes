package leecode200;

import java.util.*;

/**
 * @author xixibb
 * @date 2022/08/29
 * @desprication 49. Group Anagrams
 */
public class GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }
}
