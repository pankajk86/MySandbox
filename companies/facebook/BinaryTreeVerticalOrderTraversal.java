package facebook;

import java.util.*;

import maps.Pair;
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
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;

		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<Pair<Integer, TreeNode>> q = new LinkedList<>();
		q.add(new Pair<>(0, root));
		int min = 0, max = 0;

		while (!q.isEmpty()) {
			Pair<Integer, TreeNode> curr = q.poll();
			int col = curr.getKey();
			TreeNode node= curr.getValue();

			List<Integer> list = map.getOrDefault(col, new ArrayList<>());
			list.add(node.val);
			map.put(col, list);

			min = Math.min(min, col);
			max = Math.max(max, col);

			if (node.left != null) q.add(new Pair<>(col - 1, node.left));
			if (node.right != null) q.add(new Pair<>(col + 1, node.right));
		}


		for (int i = min; i <= max; i++)
			result.add(map.get(i));

		return result;
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
