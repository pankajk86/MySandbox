package facebook;

import java.util.ArrayList;
import java.util.List;

import trees.TreeNode;

public class SerDeBinaryTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		
		String serialized = serialize(root);
		System.out.println(serialized);
		
//		serialized = "[1]";
		TreeNode deRoot = deserialize(serialized);
		System.out.println(deRoot.val);
	}

	private static TreeNode deserialize(String serialized) {
		
		int index = serialized.indexOf(',');
		
		if(index < 0 && serialized.length() == 2) {
			return null;
		}
		
		String[] parts = serialized.substring(1, serialized.length() - 1).split(",");
		int size = parts.length;
		
		
		TreeNode[] nodes = new TreeNode[size];
		
		for(int i = 0; i < size; i++)
			nodes[i] = parts[i].equals("null") ? null : new TreeNode(Integer.parseInt(parts[i]));
		
		int left = 1, right = 2;
		
		for(int i = 0; i < size; i++) {
			if(nodes[i] != null) {
				if(left < size)
					nodes[i].left = nodes[left];
				if(right < size)
					nodes[i].right = nodes[right];
				left = right + 1;
				right = left + 1;
			}
		}
		
		return nodes[0];
	}

	private static String serialize(TreeNode root) {

		StringBuilder result = new StringBuilder();
		List<TreeNode> list = new ArrayList<>();
		list.add(root);
		int i = 0;
		
		while(i < list.size()) {
			TreeNode current = list.get(i);
			if(current != null) {
				list.add(current.left);
				list.add(current.right);
			}
			i++;
		}
		
		int end = 0;
		
		for(end = list.size() - 1; end >=0; end--) {
			if(list.get(end) != null)
				break;
		}
		
		result.append("[");
		for(i = 0; i <= end; i++) {
			result.append(list.get(i) != null ? list.get(i).val : "null").append(",");
		}
		
		return result.substring(0, result.length() - 1) + "]";
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

