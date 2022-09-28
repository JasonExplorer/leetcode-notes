package leecode100;

import common.ListNode;

/**
 * @author xixibb
 * @date 2022/08/22
 * @description 234. Palindrome Linked List (Easy)
 */
public class PalindromeLinkedList {

    /**
     * 234. 回文链表
     *
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     *
     * 输入：head = [1,2,2,1]
     * 输出：true
     * 输入：head = [1,2]
     * 输出：false
     *
     * 题目要求：以 O(1) 的空间复杂度来求解。
     * 切成两半，把后半段反转，然后比较两半是否相等。
     */
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 偶数节点，让 slow 指向下一个节点
        if (fast != null) {
            slow = slow.next;
        }

        // 切成两个链表
        cut(head, slow);

        return isEqual(head, reverse(slow));
    }

    private void cut(ListNode head, ListNode slow) {
        while (head.next != slow) {
            head = head.next;
        }
        head.next = null;
    }

    private ListNode reverse(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode  = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }

    private boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val ) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }
}
