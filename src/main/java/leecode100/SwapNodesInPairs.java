package leecode100;

import common.ListNode;

/**
 * @author xixibb
 * @date 2022/08/22
 * @desprication 24. Swap Nodes in Pairs (Medium)
 */
public class SwapNodesInPairs {

    /**
     * 24. 两两交换链表中的节点
     *
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     *
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * 输入：head = []
     * 输出：[]
     * 输入：head = [1]
     * 输出：[1]
     */
    public ListNode swapPairs(ListNode head) {

        // 虚拟出来一个节点
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode pre = node;
        while (pre.next != null && pre.next.next !=null) {
            // 节点1为当前节点， 节点2为后继几点
            ListNode l1 = pre.next;
            ListNode l2 = pre.next.next;
            // 临时变量， l1 和 l2 交换位置
            ListNode next = l2.next;
            l1.next = next;
            l2.next = l1;
            pre.next = l2;
            pre = l1;
        }
        return node.next;
    }
}
