package trees;

public class BinaryTreePruning {

	public static void main(String[] args) {
		TreeNode root = createTree();
		TreeNode result = pruneBinaryTree(root);
		System.out.println(result.val);
	}

	private static TreeNode pruneBinaryTree(TreeNode root) {
		
		if(root == null) {
			return null;
		}

		if(root.left != null)
			root.left = pruneBinaryTree(root.left);
		
		if(root.right != null)
			root.right = pruneBinaryTree(root.right);
		
		if(root.val == 0 && root.left == null && root.right == null) {
			return null;
		}
		
		return root;
	}

	private static TreeNode createTree() {

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(0);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(0);
		TreeNode node5 = new TreeNode(0);
		TreeNode node6 = new TreeNode(0);
		TreeNode node7 = new TreeNode(1);
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		
		node1.left = node2;
		node1.right = node3;
		
		return node1;
	}

}
