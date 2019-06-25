package google;

public class ReversePairs {

	public static void main(String[] args) {
		int[] a = { 1, 3, 2, 3, 1 };
		int result = reversePairs(a);
		System.out.println(result);
	}

	private static int reversePairs(int[] a) {
		int result = 0;
		RpNode root = null;
		
		for(int i: a) {
			result += search(root, 2 * i + 1);
			root = insert(root, i);
		}
		
		return result;
	}
	
	private static int search(RpNode root, long val) {
		if(root == null) return 0;
		else if(val == root.val) return root.count;
		else if(val < root.val) return root.count + search(root.left, val);
		else return search(root.right, val);
	}

	private static RpNode insert(RpNode root, int val) {
		if(root == null) root = new RpNode(val);
		else if(val == root.val) {
			root.count++;
		} else if(val < root.val) {
			root.left = insert(root.left, val);
		} else {
			root.count++;
			root.right = insert(root.right, val);
		}
		return root;
	}
	
}

class RpNode {
	int val, count;
	RpNode left, right;
	
	RpNode(int val) {
		this.val = val;
		this.count = 1;
	}
}
