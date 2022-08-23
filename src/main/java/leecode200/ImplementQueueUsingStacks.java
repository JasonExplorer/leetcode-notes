package leecode200;

import java.util.Stack;

/**
 * @author xixibb
 * @date 2022/08/23
 * @desprication 232. Implement Queue using Stacks (Easy)
 */
public class ImplementQueueUsingStacks {

    class MyQueue {
        private Stack<Integer> in = new Stack<>();
        private Stack<Integer> out = new Stack<>();

        public MyQueue() {
        }

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            in2Out();
            return out.pop();
        }

        public int peek() {
            in2Out();
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }

        private void in2Out() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }
    }
}
