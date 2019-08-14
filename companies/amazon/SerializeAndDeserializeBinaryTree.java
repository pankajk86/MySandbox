package amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import trees.TreeNode;

public class SerializeAndDeserializeBinaryTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		System.out.println(root);
		
		String encode = serialize(root);
		System.out.println(encode);
		
		TreeNode decode = deserialize(encode);
		System.out.println(decode);
	}

	private static String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}

	private static void serialize(TreeNode root, StringBuilder sb) {
		if(root == null) sb.append("#,");
		else {
			sb.append(root.val).append(",");
			serialize(root.left, sb);
			serialize(root.right, sb);
		}
	}

	private static TreeNode deserialize(String data) {
		if(data == null || data.isEmpty()) return null;
		Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
		return deserialize(q);
	}

	private static TreeNode deserialize(Queue<String> q) {
		String s = q.poll();
		if(s.equals("#")) return null;
		TreeNode root = new TreeNode(Integer.parseInt(s));
		root.left = deserialize(q); root.right = deserialize(q);
		return root;
	}

	private static TreeNode createTree() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		n4.right = n6;
		n3.left = n4; n3.right = n5;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}
