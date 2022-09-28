package leecode100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xxbb
 * @date 2022/09/23
 * @desprication 17. Letter Combinations of a Phone Number
 */
public class LetterCombinationsOfAPhoneNumber {



    // 思路：回溯法，穷举
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return res;
        }

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(map, digits, 0, new StringBuilder());
        return res;
    }

    private void backtrack(Map<Character, String> map, String digits, int index, StringBuilder sb) {

        if (digits.length() == index) {
            res.add(sb.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = map.get(digit);
            int count = letters.length();
            for (int i = 0; i < count; i++) {
                sb.append(letters.charAt(i));
                backtrack(map, digits, index + 1, sb);
                sb.deleteCharAt(index);
            }
        }
    }
}
