package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversalIterative {

    public static void main(String[] args) {

    	TreeNode root = createTree();
    	List<TreeNode> result = inorder(root);
        for(TreeNode node: result) System.out.println(node.val);
    }
    
    private static List<TreeNode> inorder(TreeNode root) {

    	Stack<TreeNode> stack = new Stack<>();
    	List<TreeNode> result = new ArrayList<>();
    	TreeNode curr = root;
    	
    	while(!stack.isEmpty() || curr != null) {
    		if(curr != null) {
    			stack.push(curr);
    			curr = curr.left;
    		} else {
    			TreeNode temp = stack.pop();
    			result.add(temp);
    			curr = temp.right;
    		}
    	}
    	
    	return result;
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
