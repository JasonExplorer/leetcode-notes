package leecode200;

import java.util.Arrays;

/**
 * @author xixibb
 * @date 2022/08/18
 * @desprication 455. Assign Cookies (Easy)
 */
public class AssignCookies {

    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     * 对每个孩子 i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
     * 并且每块饼干 j，都有一个尺寸 s[j]。如果 s[j]>= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
     * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     *
     */
    public int findContentChildren(int[] g, int[] s) {

        if (g == null  || s == null) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);

        int gi = 0;
        int si = 0;
        // 保证每次操作都是局部最优的，并且最后得到的结果是全局最优的。
        while(gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;

    }
}
