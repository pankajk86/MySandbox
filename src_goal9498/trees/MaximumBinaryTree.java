package trees;

public class MaximumBinaryTree {

	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 6, 0, 5 };
		TreeNode root = constructMaximumBinaryTree(a);
		System.out.println(root);
	}

	private static TreeNode constructMaximumBinaryTree(int[] nums) {
		if(nums == null || nums.length == 0) return null;
        return constructBT(nums, 0, nums.length - 1);
	}

	private static TreeNode constructBT(int[] a, int start, int end) {
		if(start > end) return null;
        if(start == end) return new TreeNode(a[start]);
        
        int index = getMaxValIndex(a, start, end);
        TreeNode root = new TreeNode(a[index]);
        if(index > start) root.left = constructBT(a, start, index - 1);
        if(index < end) root.right = constructBT(a, index + 1, end);
        
        return root;
	}

	private static int getMaxValIndex(int[] a, int start, int end) {
        int max = a[start], index = start;
        for(int i = start; i <= end; i++) {
            if(a[i] > max) {
                max = a[i];
                index = i;
            }
        }
        return index;
    }

}

