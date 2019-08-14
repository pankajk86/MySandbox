package google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import trees.TreeNode;

public class BottomLeftTreeValue {

	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = findBottomLeftValue(root);
		System.out.println(result);
	}

	private static int findBottomLeftValue(TreeNode root) {
		int result = root.val;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.addAll(Arrays.asList(root, null));
		
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			if(curr != null) {
				if(curr.left != null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);
			} else {
				if(q.size() > 0) {
					result = q.peek().val;
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
		
		n2.left = n4; n5.left = n7;
		n3.left = n5; n3.right = n6;
		n1.left = n2; n1.right = n3;
		return n1;
	}

}
