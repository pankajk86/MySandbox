package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}
	
	public String levelOrder() {
		List<TreeNode> list = new ArrayList<>();
		list.addAll(Arrays.asList(this, null));
		
		for(int i = 0; i < list.size(); i++) {
			TreeNode curr = list.get(i);
			if(curr != null) {
				if(curr.left != null) list.add(curr.left);
				if(curr.right != null) list.add(curr.right);
			} else {
				if(i == list.size() - 1)
					break;
				list.add(null);
			}
		}
		
		List<Integer> result = new ArrayList<>();
		for(TreeNode node: list)
			result.add(node != null ? node.val : null);
		
		return String.valueOf(result);
	}
}
