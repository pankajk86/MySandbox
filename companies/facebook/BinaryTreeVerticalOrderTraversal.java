package facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
		List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        
        for(List<int[]> value: map.values()) {
            Collections.sort(value, (a, b) -> (a[0] - b[0]));
            List<Integer> list = new ArrayList<>();
            for(int[] val: value) list.add(val[1]);
            result.add(list);
        }
        
        return result;
	}

	private static void dfs(TreeNode root, int col, int level, TreeMap<Integer, List<int[]>> map) {
		if(root == null) return;
        List<int[]> list = map.getOrDefault(col, new ArrayList<>());
        list.add(new int[] {level, root.val});
        map.put(col, list);
        
        dfs(root.left, col - 1, level + 1, map);
        dfs(root.right, col + 1, level + 1, map);
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
