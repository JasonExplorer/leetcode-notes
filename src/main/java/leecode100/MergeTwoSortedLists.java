package leecode100;

/**
 * @author xixibb
 * @date 2022/08/21
 * @desprication 21. Merge Two Sorted Lists (Easy)
 */
public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * 21. 合并两个有序链表
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     */
    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            list1.next = mergeTwoList(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoList(list1, list2.next);
            return list2;
        }
    }
}
