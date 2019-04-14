package trees;

public class SegmentTree {

	public static void main(String[] args) {
		int[] a = {18, 17, 13, 19, 15, 11, 20};
		int result = rangeMinQuery(a, 1, 5);
		System.out.println(result);
	}

	private static int rangeMinQuery(int[] a, int qlow, int qhigh) {
		int[] tree = constructMinTree(a);
		return rangeMinQuery(tree, qlow, qhigh, 0, a.length - 1, 0);
	}
	
	/**
	 * Constructs a Minimum Segment Tree
	 * 
	 * @param a
	 * @return
	 */
	private static int[] constructMinTree(int[] a) {
		int size = getPowerOfTwo(a.length);
		int[] tree = new int[2 * size - 1];
		
		constructMinTree(a, tree, 0, a.length - 1, 0);
		return tree;
	}
	
	public static void constructMinTree(int[] a, int[] tree, int low, int high, int pos) {
		if(low == high) {
			tree[pos] = a[low];
			return;
		}
		int mid = (low + high) / 2;
		constructMinTree(a, tree, low, mid, 2 * pos + 1);
		constructMinTree(a, tree, mid + 1, high, 2 * pos + 2);
		tree[pos] = Math.min(tree[2 * pos + 1], tree[2 * pos + 2]); // this statement to be changed for max or sum segment tree.
	}

	/**
	 * Queries the segment tree for the given low and high range.
	 * 
	 * @param tree
	 * @param qlow
	 * @param qhigh
	 * @param low
	 * @param high
	 * @param pos
	 * @return
	 */
	private static int rangeMinQuery(int[] tree, int qlow, int qhigh, int low, int high, int pos) {
		if(qlow <= low && qhigh >= high)
			return tree[pos];
		if(qlow > high || qhigh < low)
			return Integer.MAX_VALUE;
		
		int mid = (low + high) / 2;
		int left = rangeMinQuery(tree, qlow, qhigh, low, mid, 2 * pos + 1);
		int right = rangeMinQuery(tree, qlow, qhigh, mid + 1, high, 2 * pos + 2);
		return Math.min(left, right);
	}

	/**
	 * This method returns the next power of 2. If the input is itself a power of 2, it is returned.
	 * 
	 * @param n
	 * @return
	 */
	public static int getPowerOfTwo(int n) {
		if(ceilLog2(n) == floorLog2(n)) return n;
		else {
			int x = n;
			while(ceilLog2(x) != floorLog2(x)) {
				x++;
			}
			return x;
		}
	}
	
	private static int ceilLog2(int n) {
		return (int)(Math.ceil((Math.log(n) / Math.log(2))));
	}
	
	private static int floorLog2(int n) {
		return (int)(Math.floor((Math.log(n) / Math.log(2))));
	}
}
