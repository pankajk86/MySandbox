package facebook;

import java.util.Stack;

import trees.TreeNode;

public class InorderSuccessor {

	public static void main(String[] args) {
		TreeNode[] tree = createTree();
		TreeNode result = inorderSuccessor(tree[0], tree[1]);
		System.out.println(result);
	}
	
	private static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != p) {
        	stack.push(curr);
            curr = curr.val > p.val ? curr.left : curr.right;
        }
        
        if(p.right != null) {
            TreeNode node = p.right;
            while(node.left != null) node = node.left;
            return node;
        } else {
            while(!stack.isEmpty() && stack.peek().val <= p.val) stack.pop();
            return stack.isEmpty() ? null : stack.peek();
        }
	}

	private static TreeNode[] createTree() {
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n9 = new TreeNode(9);
		TreeNode n13 = new TreeNode(13);
		TreeNode n15 = new TreeNode(15);
		TreeNode n17 = new TreeNode(17);
		TreeNode n18 = new TreeNode(18);
		TreeNode n20 = new TreeNode(20);
		
		n3.left = n2; n3.right = n4;
		n13.left = n9; n7.right = n13;
		n6.left = n3; n6.right = n7;
		
		n18.left = n17; n18.right = n20;
		n15.left = n6; n15.right = n18;
		
		return new TreeNode[] {n15, n7};
	}

}
