package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

	static Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

	public static void main(String[] args) {
		UndirectedGraphNode node = createGraph();
		UndirectedGraphNode cloned = cloneGraph(node);
		System.out.println(cloned.label);
	}

	private static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if(node == null)
			return null;
		
		if(map.containsKey(node))
			return map.get(node);
		
		UndirectedGraphNode cnode = new UndirectedGraphNode(node.label);
		map.put(node, cnode);
		
		for(UndirectedGraphNode neighbor: node.neighbors) {
			cnode.neighbors.add(cloneGraph(neighbor));
		}
		
		return cnode;
	}

	private static UndirectedGraphNode createGraph() {

		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);
		UndirectedGraphNode n3 = new UndirectedGraphNode(3);
		
		n1.neighbors.addAll(Arrays.asList(n2, n3));
		n2.neighbors.add(n3);
		n3.neighbors.add(n3);
		
		return n1;
	}

}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}