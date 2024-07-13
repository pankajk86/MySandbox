package facebook;

import java.util.Stack;

import trees.TreeNode;

public class ConstructBinaryTreeFromString {

	public static void main(String[] args) {
		String s = "4(2(3)(1))(6(5))";
		TreeNode root = str2tree(s);
		System.out.println(root);
	}

	private static TreeNode str2tree(String s) {
		if (s == null || s.isEmpty()) return null;
		if (s.indexOf('(') == -1) return new TreeNode(Integer.parseInt(s));

		int leftOpen = s.indexOf('('), leftClose = leftOpen;
		int val = Integer.parseInt(s.substring(0, leftOpen));

		int count = 0;
		for (int i = leftOpen; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') count++;
			else if (c == ')'){
				if (count > 0) count--;
				if (count == 0) {
					leftClose = i;
					break;
				}
			}
		}

		int rightOpen = leftClose + 1, rightClose = s.length() - 1;

		TreeNode root = new TreeNode(val);
		if (leftOpen < leftClose) root.left = str2tree(s.substring(leftOpen + 1, leftClose));
		if (rightOpen < rightClose) root.right = str2tree(s.substring(rightOpen + 1, rightClose));
		return root;
	}

}
