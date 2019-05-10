package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import trees.TreeNode;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		TreeNode root = createTree();
		List<TreeNode> result = rightView(root);
		
		for(TreeNode node: result)
			System.out.print(node.val + " ");
	}

	private static List<TreeNode> rightView(TreeNode root) {

		List<TreeNode> result = new ArrayList<>();
		List<TreeNode> q = new ArrayList<>();
		q.addAll(Arrays.asList(root, null));
		
		for(int i = 0; i < q.size(); i++) {
			TreeNode curr = q.get(i);
			if(curr != null) {
				if(curr.left != null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);
			} else {
				if(i > 0 && q.get(i - 1) != null) {
					result.add(q.get(i - 1));
					q.add(null);
				}
			}
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
		
		n5.left = n6; n5.right = n7;
		n2.right = n5; n3.left = n4;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}
