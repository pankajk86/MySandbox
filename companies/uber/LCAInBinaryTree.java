package uber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import trees.TreeNode;

public class LCAInBinaryTree {

	public static void main(String[] args) {
		TreeNode[] tree = createTree();
		TreeNode result = lca(tree[0], tree[1], tree[2]);
		System.out.println(result.val);
		
		result = lcaRecursion(tree[0], tree[1], tree[2]);
		System.out.println(result.val);
	}
	
	private static TreeNode lcaRecursion(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null)
			return null;
		if(root == p || root == q)
			return root;
		TreeNode left = lcaRecursion(root.left, p, q);
		TreeNode right = lcaRecursion(root.right, p, q);
		return left != null && right != null ? root : (left == null ? right : left);
	}

	private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		
		Set<Integer> set = new HashSet<>();
		Stack<TreeNode> stack = new Stack<>();
		List<TreeNode> s1 = new ArrayList<>();
		List<TreeNode> s2 = new ArrayList<>();
		
		stack.push(root);
		set.add(root.val);
		
		while(!stack.isEmpty()) {
			TreeNode current = stack.peek();
			if(current.left != null && !set.contains(current.left.val)) {
				stack.push(current.left);
				set.add(current.left.val);
			} else {
				if(current.right != null && !set.contains(current.right.val)) {
					stack.push(current.right);
					set.add(current.right.val);
				} else {
					if(stack.peek().val == p.val)
						s1.addAll(stack);
					
					if(stack.peek().val == q.val)
						s2.addAll(stack);
					
					stack.pop();
					if(s1.size() > 0 && s2.size() > 0)
						break;
				}
			}
		}
		
		int i = 0;
		while(s1.get(i).val == s2.get(i).val) {
			if(i == s1.size() - 1 || i == s2.size() - 1) {
				return s1.get(i);
			}
			i++;
		}
		
		return s1.get(i - 1);
	}

	private static TreeNode[] createTree() {

		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		
		n5.left = n6; n5.right = n7;
		n2.left = n4; n2.right = n5;
		n3.left = n8; n3.right = n9;
		n1.left = n2; n1.right = n3;
		
		return new TreeNode[] {n1, n4, n8};
	}
}
