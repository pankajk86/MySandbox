package trees;

public class BottomLeftTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = findBottomLeftValue(root);
		System.out.println(result);

	}

	private static int findBottomLeftValue(TreeNode root) {
		NodeLevel result = helper(root, 0);
		return result.node.val;
	}

	private static NodeLevel helper(TreeNode root, int level) {

		if (root.left == null && root.right == null) {
			return new NodeLevel(root, level);
		}

		NodeLevel leftVal = null, rightVal = null;

		if (root.left != null) {
			leftVal = helper(root.left, level + 1);
		}

		if (root.right != null) {
			rightVal = helper(root.right, level + 1);
		}
		
		NodeLevel result = null;
		
		if(leftVal != null && rightVal != null) {
			result = leftVal.level > rightVal.level ? leftVal : rightVal;
		} else {
			if (leftVal != null) {
				result = leftVal;
			} else {
				result = null;
			}
		}
		return result;
	}

	private static TreeNode createTree() {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);

		node5.left = node7;
		node3.left = node5;
		node3.right = node6;
		node2.left = node4;
		node1.left = node2;
		node1.right = node3;

		return node1;
	}

}

class NodeLevel {
	TreeNode node;
	int level;
	
	NodeLevel(TreeNode node, int level) {
		this.node = node;
		this.level = level;
	}
}
