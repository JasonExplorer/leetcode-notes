package leecode200;

import common.ListNode;

import java.util.PriorityQueue;

/**
 * @author sven
 * @date 2022/09/03
 * @desprication 23. Merge k Sorted Lists
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        // 虚拟节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            if (node.next != null) {
                queue.add(node.next);
            }
            p = p.next;
        }

        return dummy.next;
    }
}
