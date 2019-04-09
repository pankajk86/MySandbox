package facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import trees.TreeNode;

public class BinaryTreeVerticalOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = createTree();
		List<List<Integer>> result = verticalTraversal(root);
		System.out.println(result);
		
		root = createTree2();
		result = verticalTraversal(root);
		System.out.println(result);
	}

	private static List<List<Integer>> verticalTraversal(TreeNode root) {
		TreeMap<Integer, List<int[]>> map = new TreeMap<>();
		helper(root, 0, 0, map);
		
		List<List<Integer>> result = new ArrayList<>();
		
		for(List<int[]> list: map.values()) {
			Collections.sort(list, new Comparator<int[]>() {
				@Override
				public int compare(int[] a, int[] b) {
					if(a[0] < b[0]) return -1;
					else if(a[1] > b[0]) return 1;
					return 0;
				}
			});
			
			List<Integer> levelOrder = new ArrayList<>();
			for(int[] arr: list)
				levelOrder.add(arr[1]);
			
			result.add(levelOrder);
		}
		return result;
	}

	private static void helper(TreeNode node, int col, int level, Map<Integer, List<int[]>> map) {
		if(node == null) return;
		
		List<int[]> list = map.getOrDefault(col, new ArrayList<>());
		list.add(new int[] {level, node.val});
		map.put(col, list);
		
		if(node.left != null)
			helper(node.left, col - 1, level + 1, map);
		
		if(node.right != null)
			helper(node.right, col + 1, level + 1, map);
		
		return;
	}
	
	private static TreeNode createTree2() {
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(0);
		TreeNode n6 = new TreeNode(1);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(5);
		
		n5.right = n8;
		n2.left = n4; n2.right = n5;
		n6.left = n9;
		n3.left = n6; n3.right = n7;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(8);
		TreeNode n7 = new TreeNode(9);
		
		n7.left = n4; n7.right = n1;
		n6.left = n2; n6.right = n5;
		n3.left = n7; n3.right = n6;
		
		return n3;
	}

}
