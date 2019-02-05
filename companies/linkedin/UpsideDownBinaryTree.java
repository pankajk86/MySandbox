package linkedin;

import trees.TreeNode;

public class UpsideDownBinaryTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		TreeNode result = upsideDown(root);
		System.out.println(result.levelOrder());
	}

	private static TreeNode upsideDown(TreeNode root) {
		TreeNode curr = root, prev = null, temp = null;
		
		while(curr != null) {
			TreeNode next = curr.left;
			
			curr.left = temp;
			temp = curr.right;
			curr.right = prev;
			
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static TreeNode createTree() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n2.left = n4; n2.right = n5;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}
