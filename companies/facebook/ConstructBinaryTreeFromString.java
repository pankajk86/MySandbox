package facebook;

import java.util.Stack;

import trees.TreeNode;

public class ConstructBinaryTreeFromString {

	public static void main(String[] args) {
		String s = "4(2(3)(1))(6(5))";
		TreeNode root = createTree(s);
		System.out.println(root);
	}

	private static TreeNode createTree(String s) {
		if(s == null || s.isEmpty()) return null;
		
		int index = s.indexOf('(');
		if(index == -1) return new TreeNode(Integer.parseInt(s));
		
		int val = Integer.parseInt(s.substring(0, index));
		String left = parse(s, index);
		String right = parse(s, index + left.length() + 2);
		
		TreeNode root = new TreeNode(val);
		root.left = createTree(left);
		root.right = createTree(right);
		return root;
	}

	private static String parse(String s, int index) {
		if(index >= s.length()) return "";
		Stack<Character> stack = new Stack<>();
		int i = index; stack.push(s.charAt(i));
		
		while(!stack.isEmpty()) {
			char c = s.charAt(++i);
			if(c == '(') stack.push(c);
			else if(c == ')') stack.pop();
		}
		return s.substring(index + 1, i);
	}

}
