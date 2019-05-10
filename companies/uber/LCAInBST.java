package uber;

import trees.TreeNode;

public class LCAInBST {

	public static void main(String[] args) {
		TreeNode[] tree = createTree();
		TreeNode result = lca(tree[0], tree[1], tree[2]);
		System.out.println(result.val);
	}

	private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) return null;
		
		if(root.val > p.val && root.val > q.val)
			return lca(root.left, p, q);
		if(root.val < p.val && root.val < q.val)
			return lca(root.right, p, q);
		
		return root;
	}

	private static TreeNode[] createTree() {

		TreeNode n1 = new TreeNode(20);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(22);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(12);
		TreeNode n6 = new TreeNode(10);
		TreeNode n7 = new TreeNode(14);
		
		n5.left = n6; n5.right = n7;
		n2.left = n4; n2.right = n5;
		n1.left = n2; n1.right = n3;
		
		return new TreeNode[] {n1, n3, n6};
	}
}
