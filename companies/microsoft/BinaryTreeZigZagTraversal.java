package microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import trees.TreeNode;

public class BinaryTreeZigZagTraversal {

	public static void main(String[] args) {
		TreeNode root = createTree();
		List<List<Integer>> result = zigzagLevelOrder(root);
		
		for(List<Integer> level: result) {
			for(int i: level) System.out.print(i + " ");
			System.out.println();
		}
	}

	private static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();
		List<TreeNode> list = new ArrayList<>();
		List<TreeNode> currList = new ArrayList<>();
		
		list.add(root); list.add(null);
		int i = 0, flag = 0;
		
		while(i < list.size()) {
			TreeNode current = list.get(i);
			
			if(current != null) {
				currList.add(current);
				if(current.left != null) list.add(current.left);
				if(current.right != null) list.add(current.right);
			} else {
				List<Integer> intList = new ArrayList<>();
				for(TreeNode node: currList)
					intList.add(node.val);
				if(flag == 0) {
					flag = 1;
				} else {
					Collections.reverse(intList);
					flag = 0;
				}
				if(intList.size() > 0) result.add(intList);
				else break;
				list.add(null);
				currList = new ArrayList<>();
			}
			i++;
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
