package google;

import java.util.Stack;

import trees.TreeNode;

public class SplitBST {

	public static void main(String[] args) {
		TreeNode root = createTree();
		TreeNode[] roots = splitBST(root, 2);
		System.out.println("Two Roots: " + roots[0].val + ", " + roots[1].val);
		
		root = createTree2();
		roots = splitBST(root, 6);
		System.out.println("Two Roots: " + roots[0].val + ", " + roots[1].val);
	}

	private static TreeNode[] splitBST(TreeNode root, int v) {
		if(root == null) return new TreeNode[] {null, null};
		
		TreeNode[] splitted;
		
		if(root.val <= v) {
			splitted = splitBST(root.right, v);
			root.right = splitted[0];
			splitted[0] = root;
		} else {
			splitted = splitBST(root.left, v);
			root.left = splitted[1];
			splitted[1] = root;
		}
		
		return splitted;
	}


	@SuppressWarnings("unused")
	private static TreeNode[] splitBST2(TreeNode root, int v) {
		NodePath nodePath = findNodes(root, v);
		TreeNode node = nodePath.node;
		Stack<TreeNode> path = nodePath.path;
		
		if(path.isEmpty()) {
			TreeNode right = node.right;
			node.right = null;
			return new TreeNode[] {root, right};
		}
		
		TreeNode currParent = path.peek(), parent = path.peek();
		
		while(parent.val < node.val) {
			parent = path.pop();
		}
		
		parent = path.peek();
		
		if(currParent.val == parent.val) {
			if(node.val < parent.val) {
				parent.left = node.right;
				return new TreeNode[] {root, node};
			} else {
				TreeNode right = node.right;
				node.right = null;
				return new TreeNode[] {root, right};
			}
		} else {
			if(node.val < parent.val) {
				TreeNode left = parent.left;
				parent.left = node.right;
				return new TreeNode[] {root, left};
			} else {
				TreeNode right = parent.right;
				parent.right = node.left;
				return new TreeNode[] {root, right};
			}
		}
	}

	private static NodePath findNodes(TreeNode root, int v) {
		Stack<TreeNode> parent = new Stack<>();
		
		while(root.val != v) {
			parent.push(root);
			if(v < root.val) root = root.left;
			else root = root.right;
		}
		
		return new NodePath(root, parent);
	}
	
	
	private static TreeNode createTree2() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		
		n2.left = n1; n2.right = n3;
		n6.left = n5; n6.right = n7;
		n4.left = n2; n4.right = n6;
		n8.left = n4; n8.right = n9;
		
		return n8;
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

class NodePath {
	TreeNode node;
	Stack<TreeNode> path;
	
	NodePath(TreeNode node, Stack<TreeNode> path) {
		this.node = node;
		this.path = path;
	}
}

