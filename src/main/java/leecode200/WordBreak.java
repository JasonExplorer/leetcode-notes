package leecode200;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author xxbb
 * @date 2022/09/25
 * @desprication 139. Word Break
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordDictSet = new HashSet<>(wordDict);
        //
        boolean[] dp = new boolean[s.length() +1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
