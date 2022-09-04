package leecode200;

import java.util.*;

/**
 * @author sven
 * @date 2022/09/04
 * @desprication 239. Sliding Window Maximum
 */
public class SlidingWindowMaximum {

    /**
     思路：求解最大值的问题，可以化解为优先级队列（堆）
     初始时，我们将数组 nums 的前 kk 个元素放入优先队列中。
     每当我们向右移动窗口时，我们就可以把一个新的元素放入优先队列中，此时堆顶的元素就是堆中所有元素的最大值。

     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0]: o2[1] - o1[1];
            }
        });

        // 初始化，优先级队列的最大值
        for (int i = 0; i < k; i++) {
            pq.add(new int[]{nums[i], i});
        }
        int[] res = new int[n - k +1];
        // 初始化大顶堆的值
        res[0] = pq.peek()[0];
        // 滑动窗口向右移动
        for (int i =k; i<n; i++) {
            pq.offer(new int[]{nums[i], i});
            // 判断栈顶元素的下标是否小于i-k 不在滑动窗口的范围，出队
            while(pq.peek()[1] <= i-k) {
                pq.poll();
            }
            res[i-k+1] = pq.peek()[0];
        }
        return res;
    }

    /**
     思路：单调队列

     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i =0; i < k; i++) {
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] res = new int[n -k +1];
        res[0] = nums[deque.peekLast()];
        for (int i = k; i< n; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while(deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }
            res[n-k+1] = nums[deque.peekLast()];
        }
        return res;
    }
}
