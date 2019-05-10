package google;

import trees.TreeNode;

public class CountCompleteTreeNodes {

	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = countNodes(root);
		System.out.println(result);
	}

	private static int countNodes(TreeNode root) {
		int left = leftDepth(root);
        int right = rightDepth(root);
        
        if(left == right) return (1 << left) - 1;
        else return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	private static int leftDepth(TreeNode root) {
        int depth = 0;
        while(root != null) {
            depth++; root = root.left;
        }
        return depth;
    }
    
    private static int rightDepth(TreeNode root) {
        int depth = 0;
        while(root != null) {
            depth++; root = root.right;
        }
        return depth;
    }

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);

		n2.left = n4; n2.right = n5;
		n3.left = n6;
		n1.left = n2;n1.right = n3;

		return n1;
	}

}
