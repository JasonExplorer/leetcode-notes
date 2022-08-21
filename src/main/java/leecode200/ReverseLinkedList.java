package leecode200;

/**
 * @author xixibb
 * @date 2022/08/21
 * @desprication 206. Reverse Linked List (Easy)
 */
public class ReverseLinkedList {

    /**
     * 206. 反转链表
     *
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     */
    public ListNode reverseList(ListNode head) {

        // 方法一
        /*if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newNode = reverseList(next);
        next.next = head;
        head.next = null;
        return newNode;*/

        // 方法二迭代
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;

    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
