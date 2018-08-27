package trees;

import java.util.ArrayList;
import java.util.List;

public class RecoverBST {
	
	static List<TreeNode> inorder = new ArrayList<>();
	static TreeNode[] test = new TreeNode[2];
	static TreeNode temp = null;
	static int k = 0;

	public static void main(String[] args) {
		TreeNode root = createTree();
		recoverBST(root);
		System.out.println(root.val);
		
		TreeNode root2 = createTree2();
		inorder(root2);
		System.out.println();
	}

	private static TreeNode createTree2() {

		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n2.left = n1; n2.right = n6;
		n3.left = n5; n3.right = n7;
		n4.left = n2; n4.right = n3;
		
		return n4;
	}

	// need to work on
	private static void inorder(TreeNode root) {
		if(root == null) return;
		
		if(temp != null) {
			if(root.val < temp.val && k < 2) {
				if(k == 0)
					test[k++] = temp;
				else
					test[k++] = root;
			}
			temp = root;
		}
		
		inorder(root.left);
		
		if(temp != null) {
			if(root.val < temp.val && k < 2) {
				if(k == 0)
					test[k++] = temp;
				else
					test[k++] = root;
			}
		}
		temp = root;
		
		inorder(root.right);
	}

	private static void recoverBST(TreeNode root) {
		inorderTraversal(root);
		TreeNode[] swapped = findSwapped();
		int temp = swapped[0].val;
		swapped[0].val = swapped[1].val;
		swapped[1].val = temp;
	}

	private static void inorderTraversal(TreeNode root) {
		if(root == null)
			return;
		
		inorderTraversal(root.left);
		inorder.add(root);
		inorderTraversal(root.right);
	}

	private static TreeNode[] findSwapped() {

		TreeNode[] result = new TreeNode[2];
		int j = -1, k = 0;
		
		for(int i = 1; i < inorder.size(); i++) {
			if(inorder.get(i).val < inorder.get(i - 1).val) {
				if(k == 0) {
					result[k++] = inorder.get(i - 1);
					j = i;
				} else if(k == 1) {
					result[k++] = inorder.get(i);
					break;
				}
			}
		}
		
		if(k == 1) {
			result[k++] = inorder.get(j);
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
		TreeNode n8 = new TreeNode(8);
		
		n8.left = n1; n8.right = n3;
		n7.right = n2;
		n6.left = n5; n6.right = n7;
		n4.left = n8; n4.right = n6;
		
		return n4;
	}

}
