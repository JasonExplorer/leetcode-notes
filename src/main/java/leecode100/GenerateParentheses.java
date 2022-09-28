package leecode100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xxbb
 * @date 2022/09/23
 * @desprication 22. Generate Parentheses
 */
public class GenerateParentheses {


    List<String> res = new ArrayList<>();

    /**
     * 思路：穷举回溯
     * n 每个括号都有两个选择
     *
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0 ) {
            return res;
        }
        backtrack(new char[2*n], 0);
        return res;
    }

    private void backtrack(char[] current, int index) {
        if (index == current.length) {
            if (isValid(current)) {
                res.add(new String(current));
            }
        } else {
            current[index] = '(';
            backtrack(current, index +1);
            current[index] = ')';
            backtrack(current, index +1);
        }
    }

    private boolean isValid(char[] current) {
        int cnt = 0;
        for (char c : current) {
            if (c == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt < 0) {
                return false;
            }
        }
        return cnt == 0;
    }

}
