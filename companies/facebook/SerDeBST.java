package facebook;

import java.util.ArrayList;
import java.util.List;

import trees.TreeNode;

public class SerDeBST {

	public static void main(String[] args) {
		TreeNode root = createTree();
		
		String encode = serialize(root);
		System.out.println(encode);
		
		TreeNode decode = deserialize(encode);
		System.out.println(decode.val);
	}

	private static TreeNode deserialize(String encode) {

		String[] parts = encode.split(",");
		int size = parts.length;
		
		TreeNode[] nodes = new TreeNode[size];
		
		for(int i = 0; i < size; i++)
			nodes[i] = parts[i].equals("#") ? null : new TreeNode(Integer.parseInt(parts[i]));
		
		int left = 1, right = 2;
		
		for(int i = 0; i < size; i++) {
			TreeNode current = nodes[i];
			
			if(current != null) {
				if(left < size) current.left = nodes[left];
				if(right < size) current.right = nodes[right];
			}
			left = right + 1;
			right = left + 1;
		}
		
		return nodes[0];
	}

	private static String serialize(TreeNode root) {

		StringBuilder sb = new StringBuilder();
		List<TreeNode> list = new ArrayList<>();
		list.add(root);
		int i = 0;
		
		while(i < list.size()) {
			TreeNode current = list.get(i);
			sb.append(current != null ? current.val : "#").append(",");
			if(current != null) {
				list.add(current.left);
				list.add(current.right);
			}
			i++;
		}
		
		return sb.substring(0, sb.length() - 1);
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
