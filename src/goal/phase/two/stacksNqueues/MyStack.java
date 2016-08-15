package goal.phase.two.stacksNqueues;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {

    List<T> stack;

    public MyStack() {
        stack = new ArrayList<>();
    }

    public void push(T data) {
        stack.add(data);
    }

    public T peek() {
        return stack.get(stack.size() - 1);
    }

    public T pop() {
        return stack.remove(stack.size() - 1);
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }
}
