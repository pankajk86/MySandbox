package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import trees.TreeNode;

public class MostFrequentSubtreeSum {

	public static void main(String[] args) {
		TreeNode root = createTree();
		int[] result = findFrequentTreeSum(root);
		
		for(int i: result) System.out.print(i + " ");
	}

	private static int[] findFrequentTreeSum(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<>();
		preOrder(root, map);
		int maxFreq = 0;
		
		for(int freq: map.values())
			maxFreq = Math.max(maxFreq, freq);
		
		List<Integer> list = new ArrayList<>();
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			if(entry.getValue() == maxFreq)
				list.add(entry.getKey());
		}
		
		int[] result = new int[list.size()];
		for(int i = 0; i < list.size(); i++)
			result[i] = list.get(i);
		
		return result;
	}

	private static int preOrder(TreeNode root, Map<Integer, Integer> map) {
		if(root == null) return 0;
		if(root.left == null && root.right ==null) {
			map.put(root.val, map.getOrDefault(root.val, 0) + 1);
			return root.val;
		}
		
		int left = preOrder(root.left, map);
		int right = preOrder(root.right, map);
		int sum = root.val + left + right;
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		return sum;
	}

	private static TreeNode createTree() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(-2);
		TreeNode n6 = new TreeNode(2);
		TreeNode n7 = new TreeNode(3);
		TreeNode n8 = new TreeNode(3);
		TreeNode n9 = new TreeNode(4);
		
		n7.left = n5; n7.right = n6;
		n3.left = n1; n3.right = n7;
		n4.left = n2; n4.right = n8;
		n9.left = n3; n9.right = n4;
		
		return n9;
	}

}
