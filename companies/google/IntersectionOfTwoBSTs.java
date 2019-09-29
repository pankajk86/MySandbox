package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import trees.TreeNode;

public class IntersectionOfTwoBSTs {

	public static void main(String[] args) {
		TreeNode root1 = createTree1();
		TreeNode root2 = createTree2();
		
		List<Integer> result = intersectionOfBST(root1, root2);
		System.out.println(result);
	}

	private static List<Integer> intersectionOfBST(TreeNode root1, TreeNode root2) {
		List<Integer> result = new ArrayList<>();
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		TreeNode curr1 = root1, curr2 = root2;
		
		while(curr1 != null) {
			stack1.push(curr1); curr1 = curr1.left;
		}
		while(curr2 != null) {
			stack2.push(curr2); curr2 = curr2.left;
		}
		
		while(!stack1.isEmpty() && !stack2.isEmpty()) {
			TreeNode peek1 = stack1.peek(), peek2 = stack2.peek();
			if(peek1.val < peek2.val) {
				remove(peek1, stack1);
			} else if(peek1.val > peek2.val) {
				remove(peek2, stack2);
			} else {
				result.add(peek1.val);
				remove(peek1, stack1);
				remove(peek2, stack2);
			}
		}
		return result;
	}
	
	private static void remove(TreeNode node, Stack<TreeNode> stack) {
		if(!stack.isEmpty()) stack.pop();
		if(node.right != null) {
			node = node.right;
			while(node != null) {
				stack.push(node);
				node = node.left;
			}
		}
	}

	private static TreeNode createTree1() {
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n7 = new TreeNode(7);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		
		n7.right = n9;
		n10.left = n7;
		n1.left = n0; n1.right = n4;
		n5.left = n1; n5.right = n10;
		return n5;
	}

	private static TreeNode createTree2() {
		TreeNode n4 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		TreeNode n20 = new TreeNode(20);
		
		n7.left = n4; n7.right = n9;
		n10.left = n7; n10.right = n20;
		return n10;
	}

}
