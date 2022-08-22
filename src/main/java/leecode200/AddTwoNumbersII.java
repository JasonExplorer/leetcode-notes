package leecode200;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author xixibb
 * @date 2022/08/22
 * @desprication 445. Add Two Numbers II (Medium)
 */
public class AddTwoNumbersII {

    /**
     * 445. 两数相加 II
     *
     * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/add-two-numbers-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = buildStack(l1);
        Stack<Integer> stack2 = buildStack(l2);

        ListNode head = new ListNode(-1);
        // 相加大于10 进位
        int carray = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty() || carray != 0) {

            int x = stack1.isEmpty() ? 0: stack1.pop();
            int y = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = x +y;
            // new 一个节点， 头插法插入节点
            ListNode node  = new ListNode(sum % 10);
            node.next = head.next;
            head.next = node;
            carray = sum/10;
        }

        return head.next;
    }

    private Stack buildStack(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while(listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        return stack;
    }


}
