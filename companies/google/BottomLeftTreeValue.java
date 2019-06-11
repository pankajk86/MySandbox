package google;

import java.util.ArrayList;
import java.util.List;

import trees.TreeNode;

public class BottomLeftTreeValue {

	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = findBottomLeftValue(root);
		System.out.println(result);
	}

	private static int findBottomLeftValue(TreeNode root) {
		List<TreeNode> q = new ArrayList<>();
		q.add(root); q.add(null);
		int i = 0;
		
		while(i < q.size()) {
			TreeNode curr = q.get(i);
			if(curr != null) {
				if(curr.left != null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);
			} else {
				if(i == q.size() - 1) break;
				q.add(null);
			}
			i++;
		}
		
		while(i >= 0 && q.get(i) == null) 
			i--;
		while(i >= 0 && q.get(i) != null)
			i--;
		
		return q.get(i + 1).val;
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
