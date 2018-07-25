package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestInBST {

	public static void main(String[] args) {
		VisitNode root = createTree();
		int result = kthSmallest(root, 3);
		System.out.println(result);
	}

	private static int kthSmallest(VisitNode root, int k) {
		Stack<VisitNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			VisitNode current = stack.peek();
			if(!current.isVisited) 
				current.isVisited = true;
			
			if(current.left != null && !current.left.isVisited) 
				stack.push(current.left);
			else {
				VisitNode node = stack.pop();
				list.add(node.val);
				if(list.size() == k)
					return list.get(list.size() - 1);
				if(node.right != null && !node.right.isVisited) 
					stack.push(node.right);
			}
		}
		
		return -1;
	}

	private static VisitNode createTree() {
		VisitNode n1 = new VisitNode(1);
		VisitNode n2 = new VisitNode(2);
		VisitNode n3 = new VisitNode(3);
		VisitNode n4 = new VisitNode(4);
		VisitNode n5 = new VisitNode(5);
		VisitNode n6 = new VisitNode(6);
		VisitNode n7 = new VisitNode(7);
		VisitNode n8 = new VisitNode(8);

        n2.left = n1; n2.right = n3;
        n8.left = n7;
        n6.left = n5; n6.right = n8;
        n4.left = n2; n4.right = n6;

        return n4;
	}

}

class VisitNode {
	VisitNode left, right;
	int val;
	boolean isVisited;
	
	VisitNode(int val) {
		this.val = val;
		this.isVisited = false;
	}
}
