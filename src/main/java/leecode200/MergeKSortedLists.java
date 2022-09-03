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
        // 优先级队列最小堆
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));

        // 将k个链表的最小堆放入队列中
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        // 遍历最小堆的队列
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
