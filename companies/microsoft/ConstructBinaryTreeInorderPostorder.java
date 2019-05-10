package microsoft;

import trees.TreeNode;

public class ConstructBinaryTreeInorderPostorder {

	public static void main(String[] args) {
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		
		TreeNode result = createTree(inorder, postorder);
		System.out.println(result);
	}

	private static TreeNode createTree(int[] inorder, int[] postorder) {
		return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	private static TreeNode helper(int[] in, int inl, int inh, int[] po, int pol, int poh) {
		if(inl > inh || pol > poh) return null;
		
		TreeNode root = new TreeNode(po[poh]);
		if(inl == inh) return root;
		
		int index = 0;
		for(int i = inl; i <= inh; i++) {
			if(in[i] == po[poh]) {
				index = i; break;
			}
		}
		
		TreeNode left = helper(in, inl, index - 1, po, pol, pol + index - inl - 1);
		TreeNode right = helper(in, index + 1, inh, po, pol + index - inl, poh - 1);
		root.left = left;
		root.right = right;
		
		return root;
	}

}
