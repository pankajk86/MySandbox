package amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import trees.TreeNode;

public class SerializeAndDeserializeBST {

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
		if(root == null) return;
		sb.append(root.val).append(",");
		serialize(root.left, sb);
		serialize(root.right, sb);
	}


	private static TreeNode deserialize(String data) {
		if(data == null || data.isEmpty()) return null;
		Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
		return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}


	private static TreeNode deserialize(Queue<String> q, int lower, int upper) {
		if(q.isEmpty()) return null;
		int val = Integer.parseInt(q.peek());
		if(val < lower || val > upper) return null;
		q.poll();
		
		TreeNode root = new TreeNode(val);
		root.left = deserialize(q, lower, val);
		root.right = deserialize(q, val, upper);
		return root;
	}


	private static TreeNode createTree() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n2.left = n1; n2.right = n3;
		n6.left = n5; n6.right = n7;
		n4.left = n2; n4.right = n6;
		
		return n4;
	}

}
