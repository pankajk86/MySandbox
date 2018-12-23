package linkedin;

import java.util.Arrays;

import trees.TreeNode;

public class SecondMinimumInBinaryTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = findSecondMinimum(root);
		System.out.println(result);
	}

	private static int findSecondMinimum(TreeNode root) {
		int result = -1;
		
		if(root == null || (root.left == null && root.right == null))
			return result;
		
//		TreeNode curr = root;
//		
//		while(curr.left != null && curr.right != null) {
//			result = curr.val;
//			if(curr.val == curr.left.val)
//				curr = curr.right;
//			else curr = curr.left;
//		}
		
		int left = getMax(root.left);
		int right = getMax(root.right);
		
		int[] temp = new int[] {left, root.val, right};
		Arrays.sort(temp);
		
		for(int i = temp.length - 1; i > 0; i--) {
			if(temp[i] != temp[i - 1])
				return temp[i - 1];
		}
		
		return result;
	}

	private static int getMax(TreeNode node) {
		
		if(node.left == null && node.right == null)
			return node.val;
		
		return Math.max(getMax(node.left), getMax(node.right));
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(7);
		
		TreeNode n6 = new TreeNode(2);
		TreeNode n7 = new TreeNode(2);
		TreeNode n8 = new TreeNode(4);
		TreeNode n9 = new TreeNode(2);
		TreeNode n10 = new TreeNode(3);
		
//		n3.left = n4; n3.right = n5;
//		n1.left = n2; n1.right = n3;
		
//		n1.left = n2; n1.right = n6;
		
		n7.left = n8; n7.right = n9;
		n2.left = n10; n2.right = n6;
		n1.left = n7; n1.right = n2;
		
		return n1;
	}

}
