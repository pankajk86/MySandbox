package microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import trees.TreeNode;

public class BinaryTreeZigZagTraversal {

	public static void main(String[] args) {
		TreeNode root = createTree();

		List<List<Integer>> result = zigzagLevelOrder2(root);
		System.out.println(result);
	}
	
	private static List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if(root == null) return result;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int size = q.size();
		boolean flag = true;
		
		while(!q.isEmpty()) {
			List<Integer> temp = new ArrayList<>();
			for(int i = 0; i < size; i++) {
				TreeNode curr = q.poll();
				if(flag) temp.add(curr.val);
				else temp.add(0, curr.val);
				
				if(curr.left != null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);
			}
			result.add(temp);
			size = q.size();
			flag = !flag;
		}
		
		return result;
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(8);
		TreeNode n5 = new TreeNode(15);
		TreeNode n6 = new TreeNode(7);
		
		n2.left = n4;
		n3.left = n5; n3.right = n6;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}
