package goal.phase.two.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import trees.TreeNode;

public class InorderSuccessor {

    public static void main(String[] args) {
    	TreeNode[] tree = createTree();
    	TreeNode result = getInorderSuccessorLinearSpace(tree[0], tree[1]);
    	System.out.println(result.val);
    	
    	result = getInorderSuccessorConstantSpace(tree[0], tree[1]);
    	System.out.println(result.val);
    }
    
    private static TreeNode getInorderSuccessorConstantSpace(TreeNode root, TreeNode p) {
    	TreeNode result = null;
    	
    	while(root != null) {
    		if(p.val < root.val) {
    			result = root;
    			root = root.left;
    		} else
    			root = root.right;
    	}
    	return result;
    }

	private static TreeNode getInorderSuccessorLinearSpace(TreeNode root, TreeNode p) {
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
            if(result.size() > 1 && result.get(result.size() - 2).val == p.val)
               return result.get(result.size() - 1);
        }
        
        return null;
	}

    private static TreeNode[] createTree() {
    	TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        
        n2.left = n1;
        n3.left = n2; n3.right = n4;
        n5.left = n3; n5.right = n6;
        
        return new TreeNode[] {n5, n2};
	}
}

