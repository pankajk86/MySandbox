package uber;

import java.util.ArrayList;
import java.util.List;

import trees.TreeNode;

public class PrintBinaryTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		List<List<String>> result = printBinaryTree(root);
		
		for(List<String> row: result) {
			for(String val: row)
				System.out.print(val + " ");
			System.out.println();
		}
	}

	private static List<List<String>> printBinaryTree(TreeNode root) {

		List<List<String>> result = new ArrayList<>();
		int height = root == null ? 1 : getHeight(root);
		int rows = height, cols = (int) Math.pow(2, height) - 1;
		
		List<String> row = new ArrayList<>();
		for(int i = 0; i < cols; i++) row.add("");
		for(int i = 0; i < rows; i++) result.add(new ArrayList<>(row));
		
		populateResult(root, result, 0, rows, 0, cols - 1);
		
		return result;
	}

	private static void populateResult(TreeNode root, List<List<String>> result, int row, int rows, int i, int j) {
		if(row == rows || root == null) return;
		
		result.get(row).set((i + j) / 2, Integer.toString(root.val));
		populateResult(root.left, result, row + 1, rows, i, (i + j) / 2 - 1);
		populateResult(root.right, result, row + 1, rows, (i + j) / 2 + 1, j);
	}

	private static int getHeight(TreeNode root) {
		if(root == null) return 0;
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	private static TreeNode createTree() {
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

}
