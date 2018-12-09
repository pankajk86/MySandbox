package linkedin;

public class MaxStackTest {

	public static void main(String[] args) {
		MaxStack stack = new MaxStack();
		stack.push(5); 
		stack.push(1);
		stack.push(5);
		
		System.out.println(stack.top());
		System.out.println(stack.popMax());
		System.out.println(stack.top());
		System.out.println(stack.peekMax());
		System.out.println(stack.pop());
		System.out.println(stack.top());
	}

}
