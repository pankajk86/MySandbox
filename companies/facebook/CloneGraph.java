package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

	static Map<UGNode, UGNode> map = new HashMap<>();

	public static void main(String[] args) {
		UGNode node = createGraph();
		UGNode cloned = cloneGraph(node);
		System.out.println(cloned.label);
	}

	private static UGNode cloneGraph(UGNode node) {

		if(node == null)
			return null;
		
		if(map.containsKey(node))
			return map.get(node);
		
		UGNode cnode = new UGNode(node.label);
		map.put(node, cnode);
		
		for(UGNode neighbor: node.neighbors) {
			cnode.neighbors.add(cloneGraph(neighbor));
		}
		
		return cnode;
	}

	private static UGNode createGraph() {

		UGNode n1 = new UGNode(1);
		UGNode n2 = new UGNode(2);
		UGNode n3 = new UGNode(3);
		
		n1.neighbors.addAll(Arrays.asList(n2, n3));
		n2.neighbors.add(n3);
		n3.neighbors.add(n3);
		
		return n1;
	}

}

class UGNode {

	int label;
	List<UGNode> neighbors;

	UGNode(int x) {
		label = x;
		neighbors = new ArrayList<UGNode>();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + label;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UGNode other = (UGNode) obj;
		if (label != other.label)
			return false;
		return true;
	}
}