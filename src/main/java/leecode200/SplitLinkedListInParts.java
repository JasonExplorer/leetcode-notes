package leecode200;

import common.ListNode;

/**
 * @author xixibb
 * @date 2022/08/22
 * @desprication 725. Split Linked List in Parts(Medium)
 */
public class SplitLinkedListInParts {

    /**
     * 725. 分隔链表
     *
     * 给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。
     * 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。
     * 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。
     * 返回一个由上述 k 部分组成的数组。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/split-linked-list-in-parts
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode[] splitListToParts(ListNode head, int k) {

        int cnt = 0;
        ListNode current = head;
        // 1、计算整个链表的长度
        while (current != null) {
            cnt++;
            current = current.next;
        }
        int mod = cnt / k;
        int sup = cnt % k;
        ListNode[] ret = new ListNode[k];
        current = head;
        for (int i = 0; current != null && i <k; i++) {
            ret[i] = current;
            int size = mod + (sup-- > 0? 1:0);
            for (int j=0; j < size - 1; j++) {
                current = current.next;
            }
            // 分割链表的尾部指向null
            ListNode next = current.next;
            current.next = null;
            current = next;
        }
        return ret;

    }
}
