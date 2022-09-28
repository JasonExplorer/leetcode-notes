package leecode100;

import common.ListNode;

/**
 * @author xixibb
 * @date 2022/08/22
 * @desprication 328. Odd Even Linked List (Medium)
 */
public class OddEvenLinkedList {

    /**
     * 328. 奇偶链表
     * 给定单链表的头节点head，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
     *
     * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为偶数 ，以此类推。
     *
     * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
     *
     * 你必须在O(1)的额外空间复杂度和O(n)的时间复杂度下解决这个问题。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/odd-even-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }
        odd.next = even;
        return head;
    }
}
