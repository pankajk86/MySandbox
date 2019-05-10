package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSInBST {

	public static void main(String[] args) {
		TreeNode root = createTree();
		List<TreeNode> result = dfsIterative(root);
		
		for(TreeNode node: result) System.out.println(node.val);
	}
	
	private static List<TreeNode> dfsIterative(TreeNode root) {

		List<TreeNode> result = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		
		while(!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			if(curr.right != null) stack.add(curr.right);
			if(curr.left != null) stack.add(curr.left);
			result.add(curr);
		}
		
		return result;
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n2.left = n1; n2.right = n3;
		n6.left = n5; n6.right = n7;
		n4.left = n2; n4.right = n6;
		
		return n4;
	}

}
