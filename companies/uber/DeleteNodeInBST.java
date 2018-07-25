package uber;

import trees.TreeNode;

public class DeleteNodeInBST {

	public static void main(String[] args) {
		TreeNode root = createTree1();
		
		root = createTree2();
		root = delete(root, 5);
	}



	private static TreeNode delete(TreeNode root, int key) {

		TreeNode parent = null;
		TreeNode toDelete = null;
		
		if(root == null)
			return root;
		
		// search
		if(key == root.val) {
			toDelete = root;
		} else {
			parent = root;
			if(key < root.val)
				toDelete = root.left;
			else
				toDelete = root.right;

			while(toDelete != null && toDelete.val != key) {
				parent = toDelete;
				if(key > toDelete.val)
					toDelete = toDelete.right;
				else if(key < toDelete.val)
					toDelete = toDelete.left;
			}
		}
		
		if(toDelete != null) {
			TreeNode current = toDelete;

			if(toDelete.right != null) {
				TreeNode next = toDelete.right;
				int flag = 0;
				
				while(next.left != null) {
					current = next; 
					next = next.left;
					flag = 1;
				}
				toDelete.val = next.val;
				
				if(flag == 1)
					current.left = null;
				else 
					current.right = null;
				
			} else if(toDelete.left != null) {
				TreeNode next = toDelete.left;
				int flag = 0;
				
				while(next.right != null) {
					current = next; 
					next = next.right;
					flag = 1;
				}
				toDelete.val = next.val;
				
				if(flag == 1)
					current.right = null;
				else 
					current.left = null;
				
			} else {
				if(parent == null)
					return null;
				else {
					if(toDelete.val > parent.val)
						parent.right = null;
					else if(toDelete.val < parent.val)
						parent.left = null;
				}
			}
		}
		
		return root;
	}
	
	private static TreeNode createTree2() {
		
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		node3.left = node2; node3.right = node4;
		node6.right = node7;
		node5.left = node3; node5.right = node6;
		
		return node5;
	}

	private static TreeNode createTree1() {

		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);

		TreeNode node10 = new TreeNode(10);
		TreeNode node12 = new TreeNode(12);
		TreeNode node13 = new TreeNode(13);
		TreeNode node14 = new TreeNode(14);
		TreeNode node15 = new TreeNode(15);

		TreeNode node16 = new TreeNode(16);
		TreeNode node17 = new TreeNode(17);
		TreeNode node18 = new TreeNode(18);
		
		node3.left = node2; node3.right = node4;
		node7.left = node6; node7.right = node8;
		node13.left = node12; node13.right = node14;
		node17.left = node16; node17.right = node18;
		node5.left = node3; node5.right = node7;
		node15.left = node13; node15.right = node17;
		node10.left = node5; node10.right = node15;
 		
		return node10;
	}

}
