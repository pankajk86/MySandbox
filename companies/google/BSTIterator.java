package google;

import java.util.Iterator;
import java.util.Stack;

import trees.TreeNode;

public class BSTIterator implements Iterator<Integer> {

	private Stack<TreeNode> stack;
	
	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		TreeNode curr = root;
		
		while(curr != null) {
			stack.push(curr.left);
			curr = curr.left;
		}
	}
	
	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	@Override
	public Integer next() {
		TreeNode curr = stack.pop();
		int val = curr.val;
		
		curr = curr.right;
		while(curr != null) {
			stack.push(curr);
			curr = curr.left;
		}
		return val;
	}
}


