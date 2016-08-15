package goal.phase.two.stacksNqueues;

public class MyStackTest {

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        MyStack<String> strStack = new MyStack<>();
        strStack.push("hello");
        strStack.push("world!!");
        strStack.push("how's");
        strStack.push("going?");

        System.out.println(strStack.peek());
    }

}
