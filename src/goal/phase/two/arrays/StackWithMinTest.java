package goal.phase.two.arrays;

import java.util.Stack;

public class StackWithMinTest {

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.push(4);
        stack.push(5);
        stack.push(2);
        stack.push(3);

        System.out.println("Size: " + stack.size() + ", peek: " + stack.peek() + ", min:" + stack.getMin());

        while (stack.size() > 1) {
            System.out.println("Popping " + stack.pop());
            System.out.println("Size: " + stack.size() + ", peek: " + stack.peek() + ", min:" + stack.getMin());
        }

    }

    private static class StackWithMin extends Stack<Integer> {
        /**
         * Auto generated serial version uid
         */
        private static final long serialVersionUID = 1L;
        Stack<Integer> minStack;

        public StackWithMin() {
            this.minStack = new Stack<>();
        }

        public void push(int n) {
            if (minStack.isEmpty()) {
                minStack.push(n);
            } else {
                if (minStack.peek() > n) {
                    minStack.push(n);
                }
            }
            super.push(n);
        }
        
        public Integer pop() {
            int value = super.pop();

            if (value == minStack.peek()) {
                minStack.pop();
            }
            return value;
        }

        public int getMin() {
            if (minStack.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return minStack.peek();
        }
    }

}
