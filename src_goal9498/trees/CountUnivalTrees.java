package trees;

public class CountUnivalTrees {
	
	private static int count = 0;

	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = countUnivalTrees(root);
		System.out.println(result);
		
		System.out.println(count);
	}
	
	private static int countUnivalTrees(TreeNode root) {
//		Count result = helper(root);
//		return result.count;
		betterHelper(root);
		return count;
	}
	
	private static boolean betterHelper(TreeNode root) {
		if(root == null) return true;
		
		boolean left = betterHelper(root.left);
		boolean right = betterHelper(root.right);
		
		if(left && right) {
			if(root.left != null && root.val == root.left.val)
				return false;
			if(root.right != null && root.val == root.right.val)
				return false;
			count++;
			return true;
		}
		
		return false;
	}
	
	@SuppressWarnings("unused")
	private static Count helper(TreeNode root) {

		if(root == null) return new Count(0, true);
		
		Count left = helper(root.left);
		Count right = helper(root.right);
		
		int count = left.count + right.count;
		
		if(left.isUnival && right.isUnival) {
			if(root.left != null && root.val != root.left.val)
				return new Count(count, false);
			if(root.right != null && root.val != root.right.val)
				return new Count(count, false);
			else
				return new Count(count + 1, true);
		}
		return new Count(count, false);
	}

	@SuppressWarnings("unused")
	private static int countUnivalTrees2(TreeNode root) {
		if(root == null) return 0;
		
		int left = countUnivalTrees2(root.left);
		int right = countUnivalTrees2(root.right);
		
		if(helper(root, root.val)) return (left + right + 1);
		else return (left + right);
	}

	private static boolean helper(TreeNode root, int value) {
		
		if(root == null) return true;
		
		if(root.val == value)
			return helper(root.left, value) && helper(root.right, value);
		
		return false;
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(5);
		TreeNode n7 = new TreeNode(5);
		
		n3.right = n7;
		n2.left = n3; n2.right = n4;
		n5.right = n6;
		n1.left = n2; n1.right = n5;
		
		return n1;
	}

}

class Count {
	int count;
	boolean isUnival;
	
	Count(int count, boolean isUnival) {
		this.count = count;
		this.isUnival = isUnival;
	}
}
