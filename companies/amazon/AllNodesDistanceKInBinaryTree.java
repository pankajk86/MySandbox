package amazon;

import java.util.*;

import trees.TreeNode;

public class AllNodesDistanceKInBinaryTree {

	private static Map<TreeNode, Integer> map = new HashMap<>();
	private static Map<TreeNode, TreeNode> parent = new HashMap<>();
	
	public static void main(String[] args) {
		TreeNode[] input = createTree(); 
		TreeNode root = input[0], target = input[1];
		int k = 2;
		List<Integer> result = distanceKWithDFS(root, target, k);
		System.out.println(result);

		result = distanceKWithBFS(root, target, k);
		System.out.println(result);

	}

	private static List<Integer> distanceKWithDFS(TreeNode root, TreeNode target, int k) {
		List<Integer> result = new ArrayList<>();
		find(root, target);
		dfs(root, k, map.get(root), result);
		return result;
	}

	private static int find(TreeNode root, TreeNode target) {
		if(root == null) return -1;
		if(root == target) {
			map.put(root, 0);
			return 0;
		}
		
		int left = find(root.left, target);
		if(left >= 0) {
			map.put(root, left + 1);
			return left + 1;
		}
		
		int right = find(root.right, target);
		if(right >= 0) {
			map.put(root, right + 1);
			return right + 1;
		}
		return -1;
	}
	
	private static void dfs(TreeNode root, int k, int length, List<Integer> result) {
		if(root == null) return;
		if(map.containsKey(root)) length = map.get(root);
		if(length == k) result.add(root.val);
		dfs(root.left, k, length + 1, result);
		dfs(root.right, k, length + 1, result);
	}

	private static List<Integer> distanceKWithBFS(TreeNode root, TreeNode target, int k) {
		List<Integer> result = new ArrayList<>();
		inorder(root);
		bfs(target, k, result);
		return result;
	}

	private static void bfs(TreeNode target, int k, List<Integer> result) {
		Queue<TreeNode> q = new LinkedList<>();
		Set<Integer> visited = new HashSet<>();
		q.add(target);
		visited.add(target.val);

		while (!q.isEmpty()) {
			int n = q.size();
			if (k == 0) break;
			while (n-- > 0) {
				TreeNode curr = q.poll();
				if (curr.left != null && !visited.contains(curr.left.val)) {
					q.add(curr.left);
					visited.add(curr.left.val);
				}

				if (curr.right != null && !visited.contains(curr.right.val)) {
					q.add(curr.right);
					visited.add(curr.right.val);
				}

				if (parent.containsKey(curr) && !visited.contains(parent.get(curr).val)) {
					q.add(parent.get(curr));
					visited.add(parent.get(curr).val);
				}
			}
			k--;
		}

		while (!q.isEmpty()) {
			result.add(q.poll().val);
		}
	}

	private static void inorder(TreeNode root) {
		if (root == null) return;
		if (root.left != null) parent.put(root.left, root);
		inorder(root.left);

		if (root.right != null) parent.put(root.right, root);
		inorder(root.right);
	}

	private static TreeNode[] createTree() {
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		
		n2.left = n7; n2.right = n4;
		n5.left = n6; n5.right = n2;
		n1.left = n0; n1.right = n8;
		n3.left = n5; n3.right = n1;
		
		return new TreeNode[] {n3, n5};
	}

}
