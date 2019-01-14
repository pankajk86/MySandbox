package linkedin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import trees.TreeNode;

public class ClosestKInBST {

	public static void main(String[] args) {
		TreeNode root = createTree();
		double target = 3.714286;
		int k = 2;
		List<Integer> result = closestKValues(root, target, k);
		System.out.println(result);
	}

	private static List<Integer> closestKValues(TreeNode root, double target, int k) {
		List<Integer> result = new ArrayList<>();
		if(root == null) return result;

		PriorityQueue<NodeVal> pq = new PriorityQueue<>(new Comparator<NodeVal>() {
			@Override
			public int compare(NodeVal n1, NodeVal n2) {
				if(n1.dist < n2.dist) return 1;
				else if(n1.dist > n2.dist) return -1;
				return 0;
			}
		});
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		
		while(!stack.isEmpty() || curr != null) {
			if(curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				TreeNode node = stack.pop();
				processNode(node, target, k, pq);
				curr = node.right;
			}
		}
		
		while(!pq.isEmpty()) {
			result.add(0, pq.poll().val);
		}
		
		return result;
	}

	private static void processNode(TreeNode node, double target, int k, PriorityQueue<NodeVal> pq) {
		double currDist = Math.abs(node.val - target);
		
		if(pq.size() < k)
			pq.add(new NodeVal(node.val, currDist));
		else {
			if(currDist < pq.peek().dist) {
				pq.remove(); 
				pq.add(new NodeVal(node.val, currDist));
			}
		}
	}

	private static TreeNode createTree() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n2.left = n1; n2.right = n3;
		n4.left = n2; n4.right = n5;
		
		return n4;
	}

}

class NodeVal {
	int val;
	double dist;
	
	NodeVal(int val, double dist) {
		this.val = val;
		this.dist = dist;
	}
}
