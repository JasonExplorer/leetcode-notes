package leecode100;

import common.ListNode;

/**
 * @author xixibb
 * @date 2022/08/21
 * @desprication 19. Remove Nth Node From End of List (Medium)
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while(n-- > 0) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }
        ListNode slow = head;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;

    }
}
